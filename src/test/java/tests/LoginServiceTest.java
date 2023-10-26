package tests;

import commons.BadRequestException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import models.member.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@DisplayName("로그인 기능 단위 테스트")
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.WARN)
public class LoginServiceTest {


    private LoginService loginService;

    @Mock
    private HttpSession session;
    @Mock
    private HttpServletRequest request;

    private Member member;

    @BeforeEach
    void init(){
        loginService = ServiceManager.getInstance().loginService();

        member = getMember();
        JoinService joinService = ServiceManager.getInstance().joinService();
        joinService.join(member);

        given(request.getSession()).willReturn(session);
    }

    private Member getMember() {
        String userPw = "12345678";
        String email = "user@test.org";
        return Member.builder()
                .email(email)
                .userPw(userPw)
                .confirmUserPw(userPw)
                .userNm("사용자")
                .ageAgree(true)
                .termsOfUser(true)
                .privacy(true)
                .thirdPartyAgree(true)
                .build();
    }

    private void createRequestData(String email, String userPw){
        given(request.getParameter("email")).willReturn(email); // 모키토 쪽에서 가짜 데이터를 받아온다.
        given(request.getParameter("userPw")).willReturn(userPw);
    }

    @Test
    @DisplayName("로그인 성공시 예외가 발생하지 않음")
    void loginSuccess(){
        Member member = getMember();
        createRequestData(member.getEmail(), member.getUserPw());
        assertDoesNotThrow(() -> {
            loginService.login(request);
        });
    }

    @Test
    @DisplayName("필수 항목 검증(이메일, 비밀번호), 검증 실패시 BadRequestException 발생")
    void requiredFiledCheck() {
        assertAll(
                () ->{
                    // 아아디 검증
                    createRequestData(null, member.getUserPw());
                    filedEachCheck(request, "이메일");

                    createRequestData(" ", member.getUserPw());
                    filedEachCheck(request, "이메일");
                },
                () ->{
                    // 비밀번호 검증
                    createRequestData(member.getEmail(),null);
                    filedEachCheck(request, "비밀번호");

                    createRequestData(member.getEmail()," ");
                    filedEachCheck(request, "비밀번호");
                }
        );
        MemberDao.clearData(); // DuplicateMemberException 발생을 막기위해
    }

    private void filedEachCheck(HttpServletRequest request, String word) {
        BadRequestException thrown = assertThrows(BadRequestException.class, () ->{
            loginService.login(request);
        });

        assertTrue(thrown.getMessage().contains(word));
    }

    @Test
    @DisplayName("이메일에 해당하는 회원 정보가 있는지 체크, 검증 실패시 MemberNotFoundException")
    void memberExistsCheck() {
        assertThrows(MemberNotFoundException.class ,()->{
           createRequestData(member.getEmail() + "**", member.getUserPw());
           loginService.login(request);
        });
        MemberDao.clearData(); // DuplicateMemberException 발생을 막기위해
    }

    @Test
    @DisplayName("비밀번호가 맞는지 체크, 검증 실패시 BadRequestException 발생")
    void passwordCheck() {
        assertThrows(BadRequestException.class, () ->{
            when(request.getParameter("userPw")).thenReturn("12345678"); // 여기서 "12345678"은 입력한 비밀번호 값
                    createRequestData(member.getEmail(), member.getUserPw() + "**");
                    loginService.login(request);
                }
        );
        MemberDao.clearData(); // DuplicateMemberException 발생을 막기위해
    }
}
