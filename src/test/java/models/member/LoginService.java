package models.member;

import commons.Validator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginService {

    private Validator<HttpServletRequest> validator;
    private MemberDao memberDao;

    public LoginService(Validator<HttpServletRequest> validator, MemberDao memberDao) {
        this.validator = validator;
        this.memberDao = memberDao;
    }

    public void login(HttpServletRequest request) {

        validator.check(request);

        // 로그인 처리 -> 세션에 담음
        String email = request.getParameter("email");
        Member member = memberDao.get(email);
        HttpSession session = request.getSession();
        session.setAttribute("member", member);

    }
}