package tests;

import commons.BadRequestException;
import jakarta.servlet.http.HttpServletRequest;
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
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.WARN)
@DisplayName("회원가입 기능 단위테스트")
public class JoinServiceTest {

    private JoinService joinService;

    @Mock
    private HttpServletRequest request;

    @BeforeEach
    void init() {
        MemberDao.clearData(); // DB 연동 시 필요 없음
        joinService = ServiceManager.getInstance().joinService();
    }

    private Member getMember() {
        String userPw = "12345678";
        return Member.builder()
                .userPw(userPw)
                .confirmUserPw(userPw)
                .userNm("user")
                .email("user@test.org")
                .ageAgree(true)
                .termsOfUser(true)
                .privacy(true)
                .thirdPartyAgree(true)
                .build();
    }

    @Test
    @DisplayName("회원가입 성공시 예외발생하지 않음")
    void joinSuccess() {
        assertDoesNotThrow(() -> {
            joinService.join(getMember());
        });
    }

    @Test
    @DisplayName("필수 항목 검증(이메일, 비밀번호, 비밀번호 확인, 회원명, 회원가입약관 동의), 검증 실패시 BadRequestException 발생")
    void requiredFieldCheck() {
        assertAll(
                ()-> {
                    //이메일 검증(email)
                    Member member = getMember();
                    member.setEmail(null);
                    filedEachCheck(member,"이메일");

                    member.setEmail(" ");
                    filedEachCheck(member, "이메일");
                },
                ()-> {
                    // 비밀번호 검증(userPw)
                    Member member = getMember();
                    member.setUserPw(null);
                    filedEachCheck(member,"비밀번호");

                    member.setUserPw(" ");
                    filedEachCheck(member, "비밀번호");
                },
                ()-> {
                    // 비밀번호 확인 검증(confirmUserPw)
                    Member member = getMember();
                    member.setConfirmUserPw(null);
                    filedEachCheck(member,"비밀번호를 확인");

                    member.setConfirmUserPw(" ");
                    filedEachCheck(member, "비밀번호를 확인");
                },
                ()-> {
                    //회원명 검증(userNm)
                    Member member = getMember();
                    member.setUserNm(null);
                    filedEachCheck(member,"회원명");

                    member.setUserNm(" ");
                    filedEachCheck(member, "회원명");
                },
                ()-> {
                    //만 14세 이상 이용 동의 검증(agree)
                    Member member = getMember();
                    member.setAgeAgree(false);
                    filedEachCheck(member,"14세");
                },
                ()-> {
                    //뮤지포트 이용약관 동의 검증(agree)
                    Member member = getMember();
                    member.setTermsOfUser(false);
                    filedEachCheck(member,"뮤지포트");
                },()-> {
                    //개인정보 수집 및 이용 약관 동의 검증(agree)
                    Member member = getMember();
                    member.setPrivacy(false);
                    filedEachCheck(member,"개인정보");
                },()-> {
                    //제3자 개인정보 제공 약관 동의 검증(agree)
                    Member member = getMember();
                    member.setThirdPartyAgree(false);
                    filedEachCheck(member,"제3자");
                }
        );
    }

    private void filedEachCheck(Member member, String word) {
        BadRequestException thrown = assertThrows(BadRequestException.class, () ->{
           joinService.join(member);
        });
        assertTrue(thrown.getMessage().contains(word));
    }

    @Test
    @DisplayName("비밀번호(8자리 이상) 최소 자리수 체크, 실패시 BadRequestException 발생")
    void fieldLengthTest(){
        assertAll(
                () ->{
                    // 비밀번호 8자리 이상 검증
                    Member member = getMember();
                    member.setUserPw("1234");
                    filedEachCheck(member, "비밀번호는 8자리");
                }
        );
    }

    @Test
    @DisplayName("비밀번호, 비밀번호 확인 입력 데이터 일치여부 체크, 검증 실패시 BadRequestException 발생")
    void passwordConfirmCheck() {
        Exception thrown = assertThrows(BadRequestException.class, () ->{
            Member member = getMember();
            member.setConfirmUserPw(member.getUserPw() + "**");
            joinService.join(member);
        });
        assertTrue(thrown.getMessage().contains("비밀번호가 일치"));
    }

    @Test
    @DisplayName("이메일 중복 가입 체크, 중복 가입인 경우 DuplicateMemberException 발생")
    void emailDuplicationJoinCheck() {
        DuplicateMemberException thrown = assertThrows(DuplicateMemberException.class, ()->{
           Member member = getMember();
           String email = member.getEmail();
           String userPw = member.getUserPw();
           joinService.join(member);
            System.out.println(member.getUserNm());

           member = getMember();
           member.setUserNm("123456767");
           member.setEmail(email);
           member.setUserPw(userPw);
            joinService.join(member);
        });
        System.out.println(thrown);
        assertTrue(thrown.getMessage().contains("이메일"));
    }

    @Test
    @DisplayName("회원명 중복 가입 체크, 중복 가입인 경우 DuplicateMemberException 발생")
    void userNmDuplicationJoinCheck() {
        DuplicateMemberException thrown = assertThrows(DuplicateMemberException.class, ()->{

            Member member = getMember();
            String userPw = member.getUserPw();
            joinService.join(member);
            System.out.println(member.getUserNm());


            member.setEmail("a"+member.getEmail()); // 이메일 중복 가입 시 예외 발생하기 때문에 이메일을 다르게 설정
            member.setUserPw(userPw);
            joinService.join(member);
            System.out.println(member.getUserNm());
        });
        System.out.println(thrown);
        assertTrue(thrown.getMessage().contains("회원명"));
    }

    @Test
    @DisplayName("HttpServletRequest 요청 데이터로 성공 테스트")
    void joinSuccessByRequest(){
        Member member = getMember();
        given(request.getParameter("userPw")).willReturn(member.getUserPw());
        given(request.getParameter("confirmUserPw")).willReturn(member.getConfirmUserPw());
        given(request.getParameter("userNm")).willReturn(member.getUserNm());
        given(request.getParameter("email")).willReturn(member.getEmail());
        given(request.getParameter("ageAgree")).willReturn(""+member.isAgeAgree());
        given(request.getParameter("termsOfUser")).willReturn(""+member.isTermsOfUser());
        given(request.getParameter("privacy")).willReturn(""+member.isPrivacy());
        given(request.getParameter("thirdPartyAgree")).willReturn(""+member.isThirdPartyAgree());
        joinService.join(request);

    }

    @Test
    @DisplayName("이메일 형식이 맞지 않을 경우 BadRequestException 발생")
    void emailCheckTest(){
        assertThrows(BadRequestException.class, ()->{
            Member member = getMember();
            member.setEmail("test");
            joinService.join(member);

        });
    }
}