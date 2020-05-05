package com.lagou.service.impl;

import com.lagou.pojo.Article;
import com.lagou.repository.ArticleRepository;
import com.lagou.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 研研
 * @date $(DATE)  $(TIME)
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;


    @Override
    public List<Article> find() {
        return articleRepository.findAll();
    }

    @Override
    public Page<Article> find(int pageNum, int pageSize) {
        PageRequest of = PageRequest.of(pageNum, pageSize);
        Page<Article> all = articleRepository.findAll(of);
        return all;
    }
}
