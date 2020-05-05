package com.lagou.service;

import com.lagou.pojo.Article;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author 研研
 * @date $(DATE)  $(TIME)
 */

public interface ArticleService {

    List<Article> find();

    Page<Article> find(int pageNum, int pageSize);

}
