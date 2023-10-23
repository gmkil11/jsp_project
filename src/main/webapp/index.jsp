<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>

<fmt:setBundle basename="messages.commons"/>
<c:url var="loginUrl" value="/member/login"/>
<c:url var="joinUrl" value="/member/join"/>
<c:url var="logoutUrl" value="/member/logout"/>
<c:url var="myPageUrl" value="/member/mypage"/>

<layout:main title="메인페이지">
    <c:if test="${sessionScope.member == null}"> <%-- 비로그인 상태 --%>
        <a href="${loginUrl}">로그인</a>
        <a href="${joinUrl}">회원가입</a>
    </c:if>
    <c:if test="${sessionScope.member != null}"> <%-- 로그인 상태 --%>
        <fmt:message key="LOGIN_MSG">
            <fmt:param>
                ${sessionScope.member.userNm}
            </fmt:param>
            <fmt:param>
                ${sessionScope.member.userId}
            </fmt:param>
        </fmt:message>
        <a href="${myPageUrl}">마이페이지</a>
        <a href="${logoutUrl}">로그아웃</a>
    </c:if>
</layout:main>