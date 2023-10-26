package member;

import commons.Validator;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Objects;

public class JoinService {
    private Validator validator = new JoinValidator();
    private MemberDao memberDao;

    public JoinService(Validator validator, MemberDao memberDao){
        this.validator = validator;
        this.memberDao = memberDao;
    }

    public void join(Member member) {
        validator.check(member);

        memberDao.register(member);

    }

    public void join(HttpServletRequest request) {
        //NullPointerException 을 방지하기 위해서
        String _ageAgree = Objects.requireNonNullElse(request.getParameter("ageAgree"),"false");
        boolean ageAgree = _ageAgree.equals("true") ? true : false;
        String _termsOfUser = Objects.requireNonNullElse(request.getParameter("termsOfUser"),"false");
        boolean termsOfUser = _termsOfUser.equals("true") ? true : false;
        String _privacy = Objects.requireNonNullElse(request.getParameter("privacy"),"false");
        boolean privacy = _privacy.equals("true") ? true : false;
        String _thirdPartyAgree = Objects.requireNonNullElse(request.getParameter("thirdPartyAgree"),"false");
        boolean thirdPartyAgree = _thirdPartyAgree.equals("true") ? true : false;


        Member member = Member.builder()
                .userNm(request.getParameter("userNm"))
                .email(request.getParameter("email"))
                .userPw(request.getParameter("userPw"))
                .confirmUserPw(request.getParameter("confirmUserPw"))
                .ageAgree(ageAgree)
                .termsOfUser(termsOfUser)
                .privacy(privacy)
                .thirdPartyAgree(thirdPartyAgree)
                .build();
        join(member);
    }

}