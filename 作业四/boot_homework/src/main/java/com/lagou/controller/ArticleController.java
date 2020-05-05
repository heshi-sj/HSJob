package com.lagou.controller;


import com.lagou.pojo.Article;
import com.lagou.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 研研
 * @date $(DATE)  $(TIME)
 */
@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

//    @RequestMapping("/index")
//    public String find(ModelMap modelMap){
//        List<Article> articles = articleService.find();
//        for (int i = 0; i < articles.size(); i++) {
//            Article article = articles.get(i);
//            System.out.println(article);
//
//            Integer id = article.getId();
//        }
//        modelMap.addAttribute("articles", articles);
//        modelMap.addAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));
//        return "index";
//    }

    @RequestMapping("/index")
    public String find(Model model, @RequestParam(value = "pageNum",defaultValue = "0") int pageNum,@RequestParam(value = "pageSize", defaultValue = "2") int pageSize){

        Page<Article> article = articleService.find(pageNum, pageSize);
        model.addAttribute("page", article);
        return "client/index";
    }
}
