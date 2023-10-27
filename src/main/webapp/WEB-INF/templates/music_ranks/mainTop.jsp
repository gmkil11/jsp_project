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
                <img src="<c:url value="images/musicImage/NewJeans.jpeg"/>" alt="앨범커버1">

                <div class="card_rank_Box" >
                    <i class="rank" style="color: #A259FF;">1</i>
                    <div class="card_info"  >
                        <span class="song_title">ETA</span>
                        <span class="song_artist">NewJeans</span>
                    </div>
                </div>
            </a>
        </li>
        <li>
            <a href="#" target="_parent">
                <img src="<c:url value="images/musicImage/NewJeans.jpeg"/>" alt="앨범커버2">
                <div class="card_rank_Box" >
                    <i class="rank" style="color: #B378FF;">2</i>
                    <div class="card_info"  >
                        <span class="song_title">Super Shy</span>
                        <span class="song_artist">NewJeans</span>
                    </div>
                </div>
            </a>
        </li>
        <li>
            <a href="#">
                <img src="<c:url value="images/musicImage/Sevne.png"/>" alt="앨범커버3">
                <div class="card_rank_Box" >
                    <i class="rank" style="color: #C08EFF">3</i>
                    <div class="card_info"  >
                        <span class="song_title">Seven (feat. Latto)</span>
                        <span class="song_artist">정국</span>
                    </div>
                </div>
            </a>
        </li>
        <li>
            <a href="#">
                <img src="<c:url value="images/musicImage/FastFor.jpeg"/>" alt="앨범커버1">
                <div class="card_rank_Box" >
                    <i class="rank" style="color: #CBA1FF">4</i>
                    <div class="card_info"  >
                        <span class="song_title">Fast Forward</span>
                        <span class="song_artist">전소미</span>
                    </div>
                </div>
            </a>
        </li>
        <li>
            <a href="#">
                <img src="<c:url value="images/musicImage/NewJeans.jpeg"/>" alt="앨범커버1">
                <div class="card_rank_Box" >
                    <i class="rank" style="color: #DFC7FF;">5</i>
                    <div class="card_info"  >
                        <span class="song_title">NewJeans</span>
                        <span class="song_artist">NewJeans</span>
                    </div>
                </div>
            </a>
        </li>
        <li>
            <a href="#">
                <img src="<c:url value="images/musicImage/robbers.png"/>" alt="앨범커버1">
                <div class="card_rank_Box" >
                    <i class="rank" style="color: #A259FF;">6</i>
                    <div class="card_info"  >
                        <span class="song_title">Buona Fortuna</span>
                        <span class="song_artist">이동규 (David DQ Lee)</span>
                    </div>
                </div>
            </a>
        </li>
        <li>
            <a href="#">
                <img src="<c:url value="images/musicImage/Ive.jpg"/>" alt="앨범커버1">
                <div class="card_rank_Box" >
                    <i class="rank" style="color: #B378FF">7</i>
                    <div class="card_info"  >
                        <span class="song_title">I AM</span>
                        <span class="song_artist">IVE (아이브)</span>
                    </div>
                </div>
            </a>
        </li>
        <li>
            <a href="#">
                <img src="<c:url value="images/musicImage/sayGoodBye.jpg"/>" alt="앨범커버1">
                <div class="card_rank_Box" >
                    <i class="rank" style="color: #C08EFF">8</i>
                    <div class="card_info"  >
                        <span class="song_title">헤어지자 말해요</span>
                        <span class="song_artist">박재정</span>
                    </div>
                </div>
            </a>
        </li>
        <li>
            <a href="#">
                <img src="<c:url value="images/musicImage/stealTheShow.jpeg"/>" alt="앨범커버1">
                <div class="card_rank_Box" >
                    <i class="rank" style="color: #CBA1FF">9</i>
                    <div class="card_info"  >
                        <span class="song_title">Steal The Show</span>
                        <span class="song_artist">Lauv(라우브)</span>
                    </div>
                </div>
            </a>
        </li>
        <li>
            <a href="#">
                <img src="<c:url value="images/musicImage/QuuenCard.jpg"/>" alt="앨범커버1">
                <div class="card_rank_Box" >
                    <i class="rank" style="color: #DFC7FF">10</i>
                    <div class="card_info"  >
                        <span class="song_title">퀸카(Queencard)</span>
                        <span class="song_artist">(여자)아이들</span>
                    </div>
                </div>
            </a>
        </li>
    </ul>
</body>