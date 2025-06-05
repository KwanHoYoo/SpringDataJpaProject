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
│   │   │       ├── config/                          # 설정 클래스
│   │   │       │   └── SecurityConfig.java          # Spring Security 설정
│   │   │       ├── controller/                      # 웹 컨트롤러
│   │   │       │   ├── AdminController.java         # 관리자 페이지 컨트롤러
│   │   │       │   ├── AuthController.java          # 인증 관련 컨트롤러
│   │   │       │   └── ProductController.java       # 상품 관리 컨트롤러
│   │   │       ├── entity/                          # JPA 엔티티
│   │   │       │   ├── Product.java                 # 상품 엔티티
│   │   │       │   ├── Role.java                    # 권한 엔티티
│   │   │       │   └── User.java                    # 사용자 엔티티
│   │   │       ├── repo/                           # 데이터 리포지토리
│   │   │       │   ├── ProductRepository.java       # 상품 리포지토리
│   │   │       │   ├── RoleRepository.java          # 권한 리포지토리
│   │   │       │   └── UserRepository.java          # 사용자 리포지토리
│   │   │       ├── service/                         # 비즈니스 로직
│   │   │       │   ├── CustomUserDetailsService.java # Spring Security 사용자 인증 서비스
│   │   │       │   ├── ProductService.java          # 상품 서비스
│   │   │       │   └── UserService.java             # 사용자 서비스
│   │   │       └── HelloSpringDataJpaApplication.java # 메인 애플리케이션 클래스
│   │   └── resources/                               # 설정 파일 및 정적 자원
│   │       ├── templates/                           # Thymeleaf 템플릿
│   │       │   ├── admin/                           # 관리자 페이지 템플릿
│   │       │   │   ├── dashboard.html               # 관리자 대시보드
│   │       │   │   └── users.html                   # 사용자 관리 페이지
│   │       │   ├── auth/                            # 인증 관련 템플릿
│   │       │   │   ├── login.html                   # 로그인 페이지
│   │       │   │   └── register.html                # 회원가입 페이지
│   │       │   ├── common.html                      # 공통 템플릿 조각
│   │       │   ├── edit_product.html                # 상품 수정 페이지
│   │       │   ├── index.html                       # 메인 페이지 (상품 목록)
│   │       │   └── new_product.html                 # 상품 등록 페이지
│   │       ├── application.properties               # 애플리케이션 설정
│   │       └── data.sql                            # 초기 데이터 SQL
│   └── test/                                       # 테스트 코드
├── target/                                         # 빌드 결과물
├── .mvn/                                          # Maven Wrapper 설정
├── mvnw                                           # Maven Wrapper (Unix)
├── mvnw.cmd                                       # Maven Wrapper (Windows)
├── pom.xml                                        # Maven 설정 파일
├── .gitignore                                     # Git 무시 파일
├── .gitattributes                                 # Git 속성 파일
└── README.md                                      # 프로젝트 설명 파일
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