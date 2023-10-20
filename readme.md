# JSP 프로젝트

## TDD를 통한 설계
### 의존성 추가(pom.xml)
1. junit 5
  - junit-jupiter 5.10.0

2. mockito
  - mockito-core 5.6.0
  - mockito-junit-jupiter 5.6.0

3. maven-sure-fire plugin
  - maven-surefire-plugin 3.1.2

4. lombok
  - lombok 1.18.30

5. jakarta servlet
  - jakarta.servlet-api 6.0.0
  - jakarta.servlet.jsp-api 3.1.1
  - jakarta.servlet.jsp.jstl-api 3.0.0
  - jakarta.servlet.jsp.jstl 3.0.1

### 톰캣10 서버 설정

### 회원가입 기능 설계(JoinService)
- models/member/JoinService.java 만들기
- 필수 항목 검증(아이디, 비밀번호, 비밀번호 확인, 회원명, 이메일, 회원가입 약관 동의)
- 아이디 중복 여부 체크 - 중복된 경우 가입 불가
- 아이디 자리수(6자리 이상), 비밀번호 자리수(8자리 이상) 체크
- 비밀번호, 비밀번호 확인 입력 데이터 일치여부 체크
- 회원 정보를 저장