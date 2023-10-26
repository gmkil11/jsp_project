<%@ tag body-content="scriptless" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ attribute name="title" %>

<c:url var="commonCss" value="/css/style.css" />
<c:url var="checkboxJs" value="/js/checkbox.js" />

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <link rel="stylesheet" type="text/css" href="${commonCss}">
    <script type="text/javascript" src="${checkboxJs}" ></script>
</head>
<body class="body">
<main>
    <jsp:doBody />
</main>
<footer class="footer">
    <img src="<c:url value='/images/musiport.svg'/> "  class="footerLogo" alt="footer_logo">
    <hr width="1300px" style="border: solid 0.5px #b0b0b0;  ">
    <p class="footerText">©musiport , Inc. 2023. We love all music!</p>
</footer>
<iframe name="ifrmProcess" class="dn" ></iframe>

</body>
</html>