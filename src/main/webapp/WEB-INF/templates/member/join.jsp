<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>

<c:url var="action" value="/member/join"/>


<layout:member title = "MusiPort 회원가입">


    <div class="loginLogoBox">
        <img src="<c:url value="/images/musiport.svg"/>" class="loginLogo" alt="logo">
    </div>

    <form class="loginInfoBox"  method="post" action="${action}" target="ifrmProcess">
        <img src="<c:url value="/images/icons/ic_baseline-perm-identity.svg"/>" class="nameIcon" alt="이름 아이콘">
        <input type="text" class="loginInfo" name="userNm" id="userNm" placeholder="이름을 입력해주세요." >

        <img src="<c:url value="/images/icons//carbon_email.svg"/>" class="emailIcon" alt="이메일 아이콘">
        <input type="text" class="loginInfo" name="email" id="email" placeholder="이메일을 입력해주세요" >

        <img src="<c:url value="/images/icons/mdi_password-outline.svg"/>" class="passwordIcon" alt="패스워드 아이콘">
        <input type="password" class="loginInfo" name="userPw" id="userPw" placeholder="비밀번호를 입력해주세요" >

        <img src="<c:url value="/images/icons/mdi_password-check-outline.svg"/>" class="passwordCheckIcon" alt="패스워드 확인 아이콘">
        <input type="password" class="loginInfo" name="confirmUserPw" id="confirmUserPw" placeholder="비밀번호를 한 번 더 입력해주세요" >

        <div class="agreeBox">
            <input type="checkbox" class="agree allAgree" id="selectAll" name="agree"  onclick='toggleAll(this)'>
            <label for="selectAll">
                <span class="allAgreeText" > 모두 확인하였으며 동의합니다. </span>
            </label>

            <hr width="100%" style="border: solid 0.5px #FFF;  ">

            <input type="checkbox" id="ageAgree" class="agree"  name="ageAgree" onclick='checkSelectAll()' value="true">
            <label for="ageAgree">
                <span class="agreeText" >만 14세 이상 이용동의 </span>
            </label>

            <input type="checkbox" id="termsOfUser" class="agree"  name="termsOfUser" onclick='checkSelectAll()' value="true">
            <label for="termsOfUser">
                <span class="agreeText" >뮤지포트 이용약관 동의 </span>
            </label>

            <input type="checkbox" id="privacy" class="agree"  name="privacy" onclick='checkSelectAll()' value="true">
            <label for="privacy">
                <span class="agreeText">개인정보 수집 및 이용 동의 </span>
            </label>

            <input type="checkbox" id="thirdPartyAgree" class="agree"  name="thirdPartyAgree" onclick='checkSelectAll()' value="true">
            <label for="thirdPartyAgree">
                <span class="agreeText" >개인정보 제3자 제공 동의 </span>
            </label>

        </div>

        <button type="submit" class="loginPageButton loginButton "> 회원가입 </button>

    </form>



</layout:member>