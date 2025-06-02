# Hello Spring Data JPA 프로젝트

## 프로젝트 개요
이 프로젝트는 Spring Boot와 Spring Data JPA를 사용한 웹 애플리케이션입니다. 한성대학교 컴퓨터공학부에서 개발된 학습용 프로젝트입니다.

## 기술 스택
- **Java**: 21
- **Spring Boot**: 3.4.5
- **Spring Data JPA**: 데이터베이스 연동
- **Thymeleaf**: 템플릿 엔진
- **MySQL**: 데이터베이스
- **Lombok**: 코드 간소화
- **Maven**: 빌드 도구

## 프로젝트 구조
```
helloSpringDataJpa/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── kr/ac/hansung/cse/hellospringdatajpa/
│   │   │       ├── controller/     # 웹 컨트롤러
│   │   │       ├── entity/         # JPA 엔티티
│   │   │       ├── repo/           # 데이터 리포지토리
│   │   │       ├── service/        # 비즈니스 로직
│   │   │       └── HelloSpringDataJpaApplication.java
│   │   └── resources/              # 설정 파일 및 정적 자원
│   └── test/                       # 테스트 코드
├── pom.xml                         # Maven 설정 파일
└── README.md
```

## 설치 및 실행

### 사전 요구사항
- Java 21 이상
- Maven 3.6 이상
- MySQL 데이터베이스

### 실행 방법
1. 프로젝트 클론 또는 다운로드
2. MySQL 데이터베이스 설정
3. `application.properties` 파일에서 데이터베이스 연결 정보 설정
4. 프로젝트 실행:
   ```bash
   # Windows
   ./mvnw.cmd spring-boot:run
   
   # Linux/Mac
   ./mvnw spring-boot:run
   ```

## 주요 기능
- Spring Data JPA를 활용한 데이터베이스 CRUD 연산
- Thymeleaf를 이용한 동적 웹 페이지 생성
- RESTful API 제공
- MySQL 데이터베이스 연동

## 개발 환경
- IDE: IntelliJ IDEA 또는 Eclipse 권장
- Java: OpenJDK 21
- Database: MySQL 8.0 이상

## 라이선스
이 프로젝트는 학습 목적으로 제작되었습니다.

## 문의사항
한성대학교 컴퓨터공학부 