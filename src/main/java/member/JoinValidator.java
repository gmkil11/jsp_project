package member;

import commons.*;

public class JoinValidator implements Validator<Member> , RequiredValidator, LengthValidator, EmailValidator {
    private MemberDao memberDao;

    public void setMemberDao(MemberDao memberDao){
        this.memberDao = memberDao;
    }

    @Override
    public void check(Member member) {
        String email = member.getEmail();
        String userPw = member.getUserPw();
        String userNm = member.getUserNm();
        String confirmUserPw = member.getConfirmUserPw();

        boolean userNms = memberDao.exists(userNm);
        boolean emails = memberDao.exists(email);


        // 필수 항목 검증 시작
        requiredCheck(email, new BadRequestException("이메일을 입력하세요"));

        requiredCheck(userPw, new BadRequestException("비밀번호를 입력하세요"));

        requiredCheck(confirmUserPw, new BadRequestException("비밀번호를 확인하세요"));

        requiredCheck(member.getUserNm(), new BadRequestException("회원명을 입력하세요"));

        requiredTrue(member.isAgeAgree(), new BadRequestException("만 14세 이상 이용 약관에 동의하세요"));

        requiredTrue(member.isTermsOfUser(), new BadRequestException("뮤지포트 이용 약관에 동의하세요"));

        requiredTrue(member.isPrivacy(), new BadRequestException("개인정보 수집 및 이용 약관에 동의하세요"));

        requiredTrue(member.isThirdPartyAgree(), new BadRequestException("개인정보 제3자 제공 약관에 동의하세요"));
        // 필수 항목 검증 끝

        // 이메일 형식 체크 시작
        emailCheck(member.getEmail(),new BadRequestException("이메일 형식을 확인해 주세요"));
        // 이메일 형식 체크 끝

        // 비밀번호 자릿수 체크 시작
        lengthCheck(userPw, 8, new BadRequestException("비밀번호는 8자리 이상 입력하세요"));
        // 비밀번호 자릿수 체크 끝

        // 비밀번호, 비밀번호 확인 일치여부 체크
        requiredTrue(userPw.equals(confirmUserPw), new BadRequestException("비밀번호가 일치하지 않습니다"));

        // 회원면 중복 가입 여부체크
        requiredTrue(!memberDao.checkDupUserNm(userNm), new DuplicateMemberException("이미 가입된 회원명 입니다"));

        // 이메일 중복 가입 여부 체크
        requiredTrue(!memberDao.exists(email), new DuplicateMemberException("이미 가입된 이메일 입니다"));

    }


}
