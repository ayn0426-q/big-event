package com.qq.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qq.mapper.ArticleMapper;
import com.qq.pojo.Article;
import com.qq.pojo.PageBean;
import com.qq.service.ArticleService;
import com.qq.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class ArticleImpl implements ArticleService {
@Autowired
private ArticleMapper articleMapper;
    @Override
    public void add(Article article) {
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());
         Map<String,Object> map=ThreadLocalUtil.get();
        Integer userId=(Integer) map.get("id");
        article.setCreateUser(userId);
        articleMapper.add(article);
    }

    @Override
    public PageBean list(Integer pageNum, Integer pageSize, Integer categoryId, String state) {
        PageBean<Article> pageBean=new PageBean<>();
        PageHelper.startPage(pageNum,pageSize);
        Map<String,Object> map=ThreadLocalUtil.get();
        Integer userId=(Integer) map.get("id");
        List<Article> as= articleMapper.list(userId,categoryId,state);
        Page<Article> p=(Page<Article> )as;
        pageBean.setTotal(p.getTotal());
        pageBean.setItems(p.getResult());
        return pageBean;
    }

    @Override
    public Article finByid(Integer id) {
        Article article=articleMapper.finByid(id);
        return article;
    }

    @Override
    public void update(Article article) {
        article.setUpdateTime(LocalDateTime.now());
        articleMapper.update(article);

    }

    @Override
    public void delete(Integer id) {
        articleMapper.delete(id);

    }
}
