<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>


<c:url var="action" value="/member/login"/>


<layout:member>
    <div class="loginLogoBox">
        <img src="<c:url value="/images/musiport.svg"/>" class="loginLogo" alt="logo">
    </div>

    <form class="loginInfoBox" method="post" action="${action}" target="ifrmProcess">


        <h1 style="color: white">${userNm}님 회원가입이 완료되었습니다.</h1>
        <button  onclick="location.href='<c:url value="/member/login"/>' " >로그인하러 가기</button>
    </form>
</layout:member>