<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>


<c:url var="action" value="/member/login"/>

<layout:member>
    <div class="loginLogoBox">
        <img src="<c:url value="/images/musiport_white.svg"/>" class="loginLogo" alt="logo">
    </div>

    <form class="loginInfoBox" method="post" action="${action}" target="ifrmProcess">




        <h1 style="color: white">${param.userNm}님 뮤지포트의 회원이 되신 것을 축하드립니다.</h1>
        <button type="button" class="loginButton" style="margin: 40px 0 " onclick="location.href='<c:url value="/member/login"/>' " >로그인하러 가기</button>
    </form>
</layout:member>