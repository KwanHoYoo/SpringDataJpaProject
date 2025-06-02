package kr.ac.hansung.cse.hellospringdatajpa;

import kr.ac.hansung.cse.hellospringdatajpa.entity.User;
import kr.ac.hansung.cse.hellospringdatajpa.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class HelloSpringDataJpaApplication {

    private final UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(HelloSpringDataJpaApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            // 역할 초기화
            userService.initializeRoles();
            
            // 관리자 계정 생성 (존재하지 않는 경우)
            if (!userService.existsByEmail("admin@test.com")) {
                User admin = new User("admin@test.com", "admin123", "관리자");
                userService.registerUser(admin, "ROLE_ADMIN");
                log.info("관리자 계정이 생성되었습니다 - 이메일: admin@test.com, 비밀번호: admin123");
            }
            
            // 일반 사용자 계정 생성 (존재하지 않는 경우)
            if (!userService.existsByEmail("user@test.com")) {
                User user = new User("user@test.com", "user123", "일반사용자");
                userService.registerUser(user, "ROLE_USER");
                log.info("일반 사용자 계정이 생성되었습니다 - 이메일: user@test.com, 비밀번호: user123");
            }
        };
    }
}
