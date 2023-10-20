package tests;

import commons.BadRequestException;
import models.member.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("회원가입 기능 단위테스트")
public class JoinServiceTest {

    private JoinService joinService;

    @BeforeEach
    void init() {
        MemberDao.clearData(); // DB 연동 시 필요 없음
        joinService = ServiceManager.getInstance().joinService();
    }

    private Member getMember() {
        String userPw = "12345678";
        return Member.builder()
                .userId("user" + System.currentTimeMillis())
                .userPw(userPw)
                .confirmUserPw(userPw)
                .userNm("사용자")
                .email("user@test.org")
                .agree(true)
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
    @DisplayName("필수 항목 검증(아이디, 비밀번호, 비밀번호 확인, 회원명, 이메일, 회원가입약관 동의), 검증 실패시 BadRequestException 발생")
    void requiredFieldCheck() {
        // 아이디(userId)가 null 또는 빈값("")
        assertAll(
                ()-> {
                    //아이디 검증(userId)
                    Member member = getMember();
                    member.setUserId(null);
                    filedEachCheck(member,"아이디");

                    member.setUserId(" ");
                    filedEachCheck(member, "아이디");

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
                    //이메일 검증(email)
                    Member member = getMember();
                    member.setEmail(null);
                    filedEachCheck(member,"이메일");

                    member.setEmail(" ");
                    filedEachCheck(member, "이메일");

                },
                ()-> {
                    //약관동의 검증(agree)
                    Member member = getMember();
                    member.setAgree(false);
                    filedEachCheck(member,"약관");

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
    @DisplayName("아아디(6자리 이상), 비밀번호(8자리 이상) 최소 자리수 체크, 실패시 BadRequestException 발생")
    void fieldLengthTest(){
        assertAll(
                () ->{
                    // 아이디 6자리 이상 검증
                    Member member = getMember();
                    member.setUserId("user");
                    filedEachCheck(member, "아이디는 6자리");
                },
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
        BadRequestException thrown = assertThrows(BadRequestException.class, () ->{
            Member member = getMember();
            member.setConfirmUserPw(member.getUserPw() + "**");
            joinService.join(member);
        });
        assertTrue(thrown.getMessage().contains("비밀번호가 일치"));
    }

    @Test
    @DisplayName("중복 가입 체크, 중복 가입인 경우 DuplicateMemberException 발생")
    void duplicationJoinCheck() {
        assertThrows(DuplicateMemberException.class, ()->{
           Member member = getMember();
           String userPw = member.getUserPw();
           joinService.join(member);

           member.setUserPw(userPw);
           joinService.join(member);
        });
    }
}