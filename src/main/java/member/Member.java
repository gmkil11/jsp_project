package member;

import lombok.Builder;
import lombok.Data;

@Builder @Data
public class Member {
    private String userPw; // 비밀번호
    private String confirmUserPw; // 비밀번호 확인
    private String userNm; // 회원명
    private String email; // 이메일
    private boolean ageAgree; // 만 14세 이상 동의
    private boolean termsOfUser; // 이용약관 동의
    private boolean privacy; // 개인정보 동의
    private boolean thirdPartyAgree; // 개인정보 제3자 제공 동의
}
