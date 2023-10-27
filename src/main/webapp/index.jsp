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
    <!-- 배너 시작 -->
    <div class="banner" name="banner">
        <img src="<c:url value="/images/banner.png"/>" class="bannerImage">
    </div>
    <!-- 배너 끝 -->

    <!-- 발매 앨범 카드 시작 -->
    <ul class="newAlbum">
        <li>
            <a href="#">
                <div class="box1 box" alt="앨범 홍보 사진 1">
                    <img class="box1_artist" src="<c:url value="/images/cards/silikagel.png"/>" alt="아티스트 로고1">
                    <br>
                    <span class="box1_info1">시간 가는줄 모르겠어</span>
                    <br>
                    <span class="box1_info2">Tik Tak Tok</span>
                    <br>
                    <span class="box1_info3">2023.08.19</span>
                </div>
            </a>
        </li>
        <li>
            <a href="#">
                <div class="box2 box" alt="앨범 홍보 사진 2">
                    <img class="box2_artist" src="<c:url value="/images/cards/Thornapple.svg"/>" alt="아티스트 로고2">
                    <br>
                    <span class="box1_info1">4년만에 돌아온 앨범</span>
                    <br>
                    <span class="box1_info2">동물</span>
                    <br>
                    <span class="box1_info3">2023.08.19 발매 예정</span>

                </div>
            </a>
        </li>
        <li>
            <a href="#">
                <div class="box3 box" alt="앨범 홍보 사진 3">
                    <span class="box3_artist">OurR</span>
                    <br>
                    <span class="box1_info1">5th Single [틈]</span>
                    <br>
                    <span class="box1_info2">OUT NOW</span>
                    <br>
                    <span class="box1_info3">2023.08.23</span>

                </div>
            </a>
        </li>
    </ul>

    <!-- 발매 앨범 카드 끝 -->
    <div class="content">
        <div class="contentButtons">
            <div class="swiper-pagination"></div>
        </div>
        <!-- 노래 정보 시작 -->
        <!-- Swiper -->

        <div class="swiper mySwiper">

            <div class="swiper-wrapper">
                <div class="swiper-slide">
                    <iframe src="<c:url value="/top10"/>" frameborder="0"></iframe>
                </div>
                <div class="swiper-slide">
                    <iframe src="<c:url value="/MD"/>" frameborder="0"></iframe>
                </div>
            </div>

        </div>
        <!-- 노래 정보 끝 -->
    </div>
    <!-- 메인 콘텐츠 끝 -->

    <!-- 중간 배너 시작 -->
    <div class="underbanner">
        <img src="<c:url value="/images/underbanner.png"/>" name="underbanner" alt="under_banner" class="underbannerImage">
        <div class="underbannerContent">
            <img src="<c:url value="/images/musiport.svg"/>"  class="underbannerLogo" alt="underbanner_logo">
            <div class="underbannerText">
                <span>자신의 노래를</span>
                <br>
                <span>자유롭게 공유 하세요!</span>
            </div>
            <a href="#">
                <button type="button" class="underbannerButton loginButton" >음악 업로드하기</button>
            </a>
        </div>
    </div>


    <!-- 중간 배너 끝 -->

    <!-- 메인 콘텐츠 끝 -->



    <%--    <c:if test="${sessionScope.member == null}"> &lt;%&ndash; 비로그인 상태 &ndash;%&gt;--%>
<%--        <a href="${loginUrl}">로그인</a>--%>
<%--        <a href="${joinUrl}">회원가입</a>--%>
<%--    </c:if>--%>
<%--    <c:if test="${sessionScope.member != null}"> &lt;%&ndash; 로그인 상태 &ndash;%&gt;--%>
<%--        <fmt:message key="LOGIN_MSG">--%>
<%--            <fmt:param>--%>
<%--                ${sessionScope.member.userNm}--%>
<%--            </fmt:param>--%>
<%--            <fmt:param>--%>
<%--                ${sessionScope.member.userId}--%>
<%--            </fmt:param>--%>
<%--        </fmt:message>--%>
<%--        <a href="${myPageUrl}">마이페이지</a>--%>
<%--        <a href="${logoutUrl}">로그아웃</a>--%>
<%--    </c:if>--%>

</layout:main>

<script src="https://cdn.jsdelivr.net/npm/swiper@11.0.0/swiper-bundle.min.js"></script>

<script src="<c:url value="/js/main.js"/>"></script>