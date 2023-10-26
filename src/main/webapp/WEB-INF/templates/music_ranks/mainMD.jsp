<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>

<c:url var="commonCss" value="/css/style.css" />

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MusiPort</title>
    <Link rel="stylesheet" type="text/css" href="${commonCss}">
</head>

<body class="body">
    <ul class="cards">
        <li>
            <a href="#" target="_parent">
                <img src="<c:url value="images/musicImage/mercurial.jpeg"/>" alt="앨범커버1">
                <div class="card_info">
                    <span class="song_title">Mercurial</span>
                </div>
                <div class="song_artist">실리카겔</div>
            </a>
        </li>
        <li>
            <a href="#" target="_parent">
                <img src="<c:url value="images/musicImage/nouvellevague.jpeg"/>" alt="앨범커버2">
                <div class="card_info">
                    <span class="song_title">Nouvelle vague</span>
                </div>
                <div class="song_artist">wave to earth</div>
            </a>
        </li>
        <li>
            <a href="#">
                <img src="<c:url value="images/musicImage/tiger.jpeg"/>" alt="앨범커버3">
                <div class="card_info">
                    <span class="song_title">호랑이</span>
                </div>
                <div class="song_artist">라이프 앤 타임</div>
            </a>
        </li>
        <li>
            <a href="#">
                <img src="<c:url value="images/musicImage/dreamOnSofa.jpeg"/>" alt="앨범커버1">
                <div class="card_info">
                    <span class="song_title">Daydream on sofa</span>
                </div>
                <div class="song_artist">SoulFa</div>
            </a>
        </li>
        <li>
            <a href="#">
                <img src="<c:url value="images/musicImage/theLights.jpeg"/>" alt="앨범커버1">
                <div class="card_info">
                    <span class="song_title">The lights behind you</span>
                </div>
                <div class="song_artist">SURL</div>
            </a>
        </li>
        <li>
            <a href="#">
                <img src="<c:url value="images/musicImage/robbers.png"/>" alt="앨범커버1">
                <div class="card_info">
                    <span class="song_title">Robbers</span>
                </div>
                <div class="song_artist">The 1975</div>
            </a>
        </li>
        <li>
            <a href="#">
                <img src="<c:url value="images/musicImage/chillOut.png"/>" alt="앨범커버1">
                <div class="card_info">
                    <span class="song_title">Chill out</span>
                </div>
                <div class="song_artist">bohemianvoodoo</div>
            </a>
        </li>
        <li>
            <a href="#">
                <img src="<c:url value="images/musicImage//Wave.jpeg"/>" alt="앨범커버1">
                <div class="card_info">
                    <span class="song_title">Wave</span>
                </div>
                <div class="song_artist">deca joins</div>
            </a>
        </li>
        <li>
            <a href="#">
                <img src="<c:url value="images/musicImage/daisy.jpeg"/>"alt="앨범커버1">
                <div class="card_info">
                    <span class="song_title">Daisy</span>
                </div>
                <div class="song_artist">Delorians</div>
            </a>
        </li>
        <li>
            <a href="#">
                <img src="<c:url value="images/musicImage/gill.jpeg"/>" alt="앨범커버1">
                <div class="card_info">
                    <span class="song_title">아가미</span>
                </div>
                <div class="song_artist">쏜애플</div>
            </a>
        </li>
    </ul>
</body>