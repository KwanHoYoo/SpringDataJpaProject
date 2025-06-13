package kr.ac.hansung.cse.hellospringdatajpa.controller;

import kr.ac.hansung.cse.hellospringdatajpa.entity.Product;
import kr.ac.hansung.cse.hellospringdatajpa.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping({"", "/"}) // products 또는 /products/ 둘 다 매핑
    public String viewHomePage(@RequestParam(value = "success", required = false) String success,
                              Model model) {

        List<Product> listProducts = service.listAll();
        model.addAttribute("listProducts", listProducts);
        
        if (success != null) {
            model.addAttribute("successMessage", "로그인에 성공했습니다!");
        }

        return "index";
    }

    @GetMapping("/new")
    @PreAuthorize("hasRole('ADMIN')")
    public String showNewProductPage(Model model) {

        Product product = new Product();
        model.addAttribute("product", product);

        return "new_product";
    }

    @GetMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String showEditProductPage(@PathVariable(name = "id") Long id, Model model) {

        Product product = service.get(id);
        model.addAttribute("product", product);

        return "edit_product";
    }

    // @ModelAttribute는  Form data (예: name=Laptop&brand=Samsung&madeIn=Korea&price=1000.00)를 Product 객체
    // @RequestBody는 HTTP 요청 본문에 포함된
    //  JSON 데이터(예: {"name": "Laptop", "brand": "Samsung", "madeIn": "Korea", "price": 1000.00})를 Product 객체에 매핑
    @PostMapping("/save")
    @PreAuthorize("hasRole('ADMIN')")
    public String saveProduct(@Valid @ModelAttribute("product") Product product, 
                             BindingResult bindingResult, 
                             Model model) {
        
        if (bindingResult.hasErrors()) {
            // 새 상품인지 편집인지 확인
            if (product.getId() == null) {
                return "new_product";
            } else {
                return "edit_product";
            }
        }

        service.save(product);
        model.addAttribute("successMessage", "상품이 성공적으로 저장되었습니다.");

        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteProduct(@PathVariable(name = "id") Long id) {

        service.delete(id);
        return "redirect:/products";
    }
}
