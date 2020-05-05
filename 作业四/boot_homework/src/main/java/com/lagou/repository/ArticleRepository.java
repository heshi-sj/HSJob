package com.lagou.repository;

import com.lagou.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 研研
 * @date $(DATE)  $(TIME)
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
