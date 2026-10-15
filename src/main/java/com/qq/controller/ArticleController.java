package com.qq.controller;

import com.auth0.jwt.JWT;
import com.qq.pojo.Article;
import com.qq.pojo.PageBean;
import com.qq.pojo.Result;
import com.qq.service.ArticleService;
import com.qq.utils.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @PostMapping
    public Result add(@RequestBody  @Validated Article article){
        articleService.add(article);
        return Result.success();
    }

    @GetMapping
    public  Result<PageBean<Article>>  list(
            Integer pageNum,Integer pageSize,@RequestParam(required = false) Integer categoryId,@RequestParam(required = false) String state
    ){
   PageBean pb=articleService.list(pageNum,pageSize,categoryId,state);
   return  Result.success(pb);

    }
    }

