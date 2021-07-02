package jp.co.cybermissions.itspj.java.myapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.cybermissions.itspj.java.myapp.models.Category;
import jp.co.cybermissions.itspj.java.myapp.models.CategoryRepository;
import jp.co.cybermissions.itspj.java.myapp.models.ReviewRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class CategoryController {

    private final CategoryRepository rep;
    private final ReviewRepository rrep;

    @GetMapping("/home/category")
    public String category(@ModelAttribute Category category, Model model) {
        model.addAttribute("categorylist", rep.findAll());
        return "category/category";
    }

    @PostMapping("/home/category")
    public String create(@ModelAttribute Category category, Model model) {
        int id = category.getId();
        model.addAttribute("category",category);
        return "redirect:/home/category/" + id;
    }


    @GetMapping("/home/category/{id}")
    public String detail(@PathVariable int id, Model model) {
        Category ct = rep.findById(id).get();
        model.addAttribute("category", ct);
        model.addAttribute("review", rrep.findByCategoryOrderById(String.valueOf(id)));
        return "category/detail";
    }

}    



    

