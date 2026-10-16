package com.qq.service;

import com.qq.pojo.Article;
import com.qq.pojo.PageBean;

public interface ArticleService {

    void add(Article article);

    PageBean list(Integer pageNum, Integer pageSize, Integer categoryId, String state);

    Article finByid(Integer id);

    void update(Article article);

    void delete(Integer id);
}
