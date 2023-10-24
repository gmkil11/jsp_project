package models.member;

import lombok.Builder;
import lombok.Data;

@Builder @Data
public class Member {
    private String userPw; // 비밀번호
    private String confirmUserPw; // 비밀번호 확인
    private String userNm; // 회원명
    private String email; // 이메일
    private boolean agree; // 약관동의
}
