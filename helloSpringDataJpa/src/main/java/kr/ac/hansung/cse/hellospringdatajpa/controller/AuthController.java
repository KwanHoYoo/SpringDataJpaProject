package kr.ac.hansung.cse.hellospringdatajpa.controller;

import kr.ac.hansung.cse.hellospringdatajpa.entity.User;
import kr.ac.hansung.cse.hellospringdatajpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Controller
@RequiredArgsConstructor
public class AuthController {
    
    private final UserService userService;
    
    @GetMapping("/login")
    public String loginForm(@RequestParam(value = "error", required = false) String error,
                           @RequestParam(value = "logout", required = false) String logout,
                           Model model) {
        if (error != null) {
            model.addAttribute("errorMessage", "이메일 또는 비밀번호가 올바르지 않습니다.");
        }
        if (logout != null) {
            model.addAttribute("successMessage", "성공적으로 로그아웃되었습니다.");
        }
        return "auth/login";
    }
    
    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "auth/register";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") User user,
                          BindingResult bindingResult,
                          @RequestParam("confirmPassword") String confirmPassword,
                          Model model) {
        
        // 이메일 중복 검사
        if (userService.existsByEmail(user.getEmail())) {
            bindingResult.rejectValue("email", "email.exists", "이미 등록된 이메일입니다.");
        }
        
        // 비밀번호 확인
        if (!user.getPassword().equals(confirmPassword)) {
            bindingResult.rejectValue("password", "password.mismatch", "비밀번호가 일치하지 않습니다.");
        }
        
        if (bindingResult.hasErrors()) {
            return "auth/register";
        }
        
        try {
            userService.registerUser(user, "ROLE_USER");
            model.addAttribute("successMessage", "회원가입이 완료되었습니다. 로그인해주세요.");
            return "auth/login";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "회원가입 중 오류가 발생했습니다.");
            return "auth/register";
        }
    }
    
    @GetMapping("/")
    public String home() {
        return "redirect:/products";
    }
    
    @GetMapping("/home")
    public String homePage() {
        return "redirect:/products";
    }
} 