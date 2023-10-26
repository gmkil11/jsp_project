<%@ tag body-content="scriptless" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ attribute name="title" %>
<%@ attribute name="header" fragment="true" %>
<%@ attribute name="footer" fragment="true" %>

<c:url var="swiperCss" value="https://cdn.jsdelivr.net/npm/swiper@11.0.0/swiper-bundle.min.css"/>
<c:url var="commonCss" value="/css/style.css" />
<c:url var="commonJs" value="/js/main.js" />
<c:url var="cssUrl" value="/css/" />
<c:url var="jsUrl" value="/js/" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <link href="${swiperCss}" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${commonCss}">
    <c:if test="${addCss != null}">
        <c:forEach var="path" items="${addCss}">
            <link rel="stylesheet" type="text/css" href="${cssUrl}${path}.css">
        </c:forEach>
    </c:if>

</head>
<body class="body">
<header>
    <jsp:invoke fragment="header" />
</header>
<main>
    <jsp:doBody />
</main>
<footer class="footer">
    <jsp:invoke fragment="footer" />
</footer>
<iframe name="ifrmProcess" class="dn" ></iframe>
</body>

</html>