package models.member;

import commons.BadRequestException;
import commons.RequiredValidator;
import commons.Validator;
import jakarta.servlet.http.HttpServletRequest;

public class LoginValidator implements Validator<HttpServletRequest>, RequiredValidator {

    private MemberDao memberDao;

    public LoginValidator(MemberDao memberDao){
        this.memberDao = memberDao;
    }
    @Override
    public void check(HttpServletRequest request) {
        String email = request.getParameter("email");
        String userPw = request.getParameter("userPw");

        // 필수 입력항목 검사
        requiredCheck(email, new BadRequestException("이메일을 입력하세요."));
        requiredCheck(userPw, new BadRequestException("비밀번호를 입력하세요."));

        // 가입된 회원인지 검사
        requiredTrue(memberDao.exists(email), new MemberNotFoundException());
    }
}