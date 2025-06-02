package kr.ac.hansung.cse.hellospringdatajpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Email(message = "올바른 이메일 형식을 입력해주세요")
    @NotBlank(message = "이메일은 필수입니다")
    @Column(unique = true, nullable = false)
    private String email;
    
    @NotBlank(message = "비밀번호는 필수입니다")
    @Column(nullable = false)
    private String password;
    
    @NotBlank(message = "이름은 필수입니다")
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private boolean enabled = true;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
    
    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
} 