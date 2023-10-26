# JSP 프로젝트

## TDD를 통한 설계
### 의존성 추가(pom.xml)
- junit 5
  - junit-jupiter 5.10.0
  

- mockito
  - mockito-core 5.6.0
  - mockito-junit-jupiter 5.6.0
  

- maven-sure-fire plugin
  - maven-surefire-plugin 3.1.2
  

- lombok
  - lombok 1.18.30


- jakarta servlet
  - jakarta.servlet-api 6.0.0
  - jakarta.servlet.jsp-api 3.1.1
  - jakarta.servlet.jsp.jstl-api 3.0.0
  - jakarta.servlet.jsp.jstl 3.0.1


### 톰캣10 서버 설정

### 회원가입 기능 설계(JoinService)
- models/member/JoinService.java 만들기
- 필수 항목 검증(이메일, 비밀번호, 비밀번호 확인, 회원명, 회원가입 약관 동의)
- 비밀번호 자리수(8자리 이상) 체크
- 비밀번호, 비밀번호 확인 입력 데이터 일치여부 체크
- 이메일 중복 여부 체크 - 중복된 경우 가입 불가
- 이메일 형식 체크 - 이메일 형식에 맞지 않는 경우 가입 불가


### 로그인 기능 설계(LoginService)
- models/member/LoginService.java 만들기
- 필수 항목 검증(이메일, 비밀번호)
- 이메일에 해당하는 회원 정보가 있는지 체크 후 로그인 처리
- 로그인 처리(세션에 회원 정보를 저장)

## 기능 통합 
### 회원가입 
  - Controller : /member/join
    - controllers/member/JoinController
    - GET : 회원가입 양식
    - POST : 회원가입 처리


  - View : /WEB-INF/templates/member/join.jsp
  
### 로그인
  - Controller : /member/login
    - controllers/member/LoginController
    - GET : 로그인 양식
    - POST : 로그인 처리


  - View : /WEB-INF/templates/member/login.jsp


### 메인페이지
  - 로그인 한 경우  join
    - 사용자명(회원명)님 로그인 메세지 출력
    - 로그아웃(/member/logout), 마이페이지(/mypage) 링크
  - 비로그인 상태
    - 회원가입(/member/join), 로그인(member/login) 링크
  - 로그아웃
    - Controller : /member/logout
      - controllers/member/LogoutController
      - GET, POST 메서드 상관 없이 기능 할 수 있도록 처리

## 완성 화면
![전체 메인 페이지](https://github.com/gmkil11/jsp_project/blob/imageReadme/images/%EC%A0%84%EC%B2%B4%20%ED%8E%98%EC%9D%B4%EC%A7%80%20%EB%A9%94%EC%9D%B8.png?raw=true)

### 회원가입
#### 회원가입 페이지 
![회원가입페이지](https://github.com/gmkil11/jsp_project/blob/imageReadme/images/%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85%20%ED%8E%98%EC%9D%B4%EC%A7%80.png?raw=true)
#### 회원가입 페이지 기입
![회원가입페이지 기입](https://github.com/gmkil11/jsp_project/blob/imageReadme/images/%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85%20%ED%8E%98%EC%9D%B4%EC%A7%80%20%EA%B8%B0%EC%9E%85.png?raw=true)
#### 회원가입 완료 페이지
![회원가입 완료 페이지](https://github.com/gmkil11/jsp_project/blob/imageReadme/images/%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85%20%EC%99%84%EB%A3%8C%20%ED%8E%98%EC%9D%B4%EC%A7%80.png?raw=true)


### 로그인
#### 로그인 페이지
![로그인페이지](https://github.com/gmkil11/jsp_project/blob/imageReadme/images/%EB%A1%9C%EA%B7%B8%EC%9D%B8%20%ED%8E%98%EC%9D%B4%EC%A7%80.png?raw=true)


### 메인 페이지
#### 헤더 및 메인베너 (비로그인 상태)
![메인페이지 비로그인](https://github.com/gmkil11/jsp_project/blob/imageReadme/images/%ED%97%A4%EB%8D%94%20%EB%B0%8F%20%EB%A9%94%EC%9D%B8%EB%B0%B0%EB%84%88%20%EB%B9%84%EB%A1%9C%EA%B7%B8%EC%9D%B8.png?raw=true)
#### 헤더 및 메인베너 (로그인 상태)
![메인페이지 로그인](https://github.com/gmkil11/jsp_project/blob/imageReadme/images/%ED%97%A4%EB%8D%94%20%EB%B0%8F%20%EB%B2%A0%EC%9D%B8%EB%B0%B0%EB%84%88%20%EB%A1%9C%EA%B7%B8%EC%9D%B8.png?raw=true)
#### 새로운 앨범 추천 
![새로운 앨범 추천](https://github.com/gmkil11/jsp_project/blob/imageReadme/images/%EC%83%88%EB%A1%9C%EC%9A%B4%20%EC%95%A8%EB%B2%94.png?raw=true)
#### 새로운 앨범 추천 (호버)
![새로운 앨범 추천 호버](https://github.com/gmkil11/jsp_project/blob/imageReadme/images/%EC%83%88%EB%A1%9C%EC%9A%B4%20%EC%95%A8%EB%B2%94%20%ED%98%B8%EB%B2%84.png?raw=true)
#### Top 10 스위퍼
![Top 10 스위퍼](https://github.com/gmkil11/jsp_project/blob/imageReadme/images/Top10%20%EC%8A%A4%EC%9C%84%ED%8D%BC.png?raw=true)
#### MD 추천 스위퍼
![MD 추천 스위퍼](https://github.com/gmkil11/jsp_project/blob/imageReadme/images/MD%EC%B6%94%EC%B2%9C%20%EC%8A%A4%EC%9C%84%ED%8D%BC.png?raw=true)
#### 하단 배너 및 푸터
![하단 배너 및 푸터](https://github.com/gmkil11/jsp_project/blob/imageReadme/images/%ED%95%98%EB%8B%A8%20%EB%B0%B0%EB%84%88%20%EB%B0%8F%20%ED%91%B8%ED%84%B0.png?raw=true)
