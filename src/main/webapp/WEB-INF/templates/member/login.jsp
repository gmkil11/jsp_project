<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>

<c:url var="action" value="/member/login"/>

<layout:member>
<div class="loginLogoBox">
    <img src="<c:url value="/images/musiport.svg"/>" class="loginLogo" alt="logo">
</div>

<form class="loginInfoBox" method="post" action="${action}" target="ifrmProcess">
    <img src="<c:url value="/images/icons/carbon_email.svg"/>" class="emailIconLogin" alt="이메일 아이콘">
    <input type="text" class="loginInfo" name="email" id="email" placeholder="이메일을 입력해주세요" required >
    <img src="<c:url value="/images/icons/mdi_password-outline.svg"/>" class="passwordIconLogin" alt="패스워드 아이콘">
    <input type="password" class="loginInfo" name="userPw" id="userPw" placeholder="비밀번호를 입력해주세요" required>
    <button type="submit" class="loginPageButton loginButton">로그인</button>
    <button class="loginPageButton loginButton createButton" onclick="location.href='<c:url value="/member/join"/>' " >회원가입</button>
</form>

<label class="forgot">
    <p style="margin-bottom: 15px;">계정을 잃어버리셨나요?</p>
    <hr width="172px" style="border: solid 0.5px #b0b0b0; ">
    <div class="forgotLink">
        <a href="#" style="margin-right: 25px;" >아이디 찾기</a>
        <a href="#">비밀번호 찾기</a>
    </div>
</label>
</layout:member>