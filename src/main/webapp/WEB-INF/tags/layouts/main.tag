<%@ tag body-content="scriptless" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ attribute name="title" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<layout:common title="${title}">
    <jsp:attribute name="header">

               <button type="button" class="button" onclick="location.href='main.html'" >
                   <img src="<c:url value='/images/musiport.svg'/>" name="logo" alt="logo">
               </button>

               <div class="searchBox">
                   <input type="text" class="searchInput" name="search" id="serchBar" placeholder="음악 찾기" >
                   <button type="submit" class="searchButton" onclick="location.href='#'" >
                   </button>
               </div>

               <label class="loginButton1">
                   <c:if test="${sessionScope.member == null}"> <%-- 비로그인 상태 --%>
                   <button  type="button" name="loginButton" class="loginButton" onclick="location.href='<c:url value="member/login"/>';" onmouseenter="this.style.cursor='hand'">
                       로그인
                   </button>
                   </c:if>
                   <c:if test="${sessionScope.member != null}"> <%-- 로그인 상태 --%>
                       <button  type="button" name="loginButton" class="loginButton" onclick="location.href='<c:url value="member/logout"/>';" onmouseenter="this.style.cursor='hand'">
                           로그아웃
                       </button>
                   </c:if>
               </label>
    </jsp:attribute>
    <jsp:attribute name="footer">
            <img src="<c:url value='/images/musiport.svg'/> "  class="footerLogo" alt="footer_logo">
            <hr width="1300px" style="border: solid 0.5px #b0b0b0;  ">
            <p class="footerText">©musiport , Inc. 2023. We love all music!</p>
    </jsp:attribute>
    <jsp:body>
        <jsp:doBody />
    </jsp:body>
</layout:common>