package com.example.springboot.cotroller;


import com.example.springboot.dto.ArticleForm;
import com.example.springboot.entity.Article;
import com.example.springboot.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(Model model) {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
       log.info(form.toString());
        Article article=form.toEntity();
        Article saved= articleRepository.save(article);
        log.info(saved.toString());
        return "redirect:/articles/new";
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model) {

        log.info("id:"+id);
        Article articleEntity= articleRepository.findById(id).orElse(null);
        model.addAttribute("article", articleEntity);

        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model) {
        ArrayList<Article> articleEntityList= articleRepository.findAll();
        model.addAttribute("articleList", articleEntityList);
        return "articles/index";
    }


}