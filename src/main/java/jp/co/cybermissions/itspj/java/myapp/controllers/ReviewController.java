package jp.co.cybermissions.itspj.java.myapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.cybermissions.itspj.java.myapp.models.Category;
import jp.co.cybermissions.itspj.java.myapp.models.CategoryRepository;
import jp.co.cybermissions.itspj.java.myapp.models.Review;
import jp.co.cybermissions.itspj.java.myapp.models.ReviewRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ReviewController {
    
    private final ReviewRepository rep;
    private final CategoryRepository crep;

    // ホーム
    @GetMapping("/home")
    public String home(Model model) {
        return "review/home";
    }

    //レビュー記入
    @GetMapping("/home/review")
    public String review(@ModelAttribute Review review, Model model)  {
        model.addAttribute("categorylist", crep.findAll());
        return "review/review";
    }

    //レビュー保存
    @PostMapping("/home/review")
    public String create(@ModelAttribute Review review, Category category) {
        int id = category.getId();
        rep.save(review);
        return "redirect:/home/category/" + id;
    }

}
