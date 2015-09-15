package com.service;

import facade.IArticleFacade;
import model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CataVlad on 10-Sep-15.
 */
@Controller
@RequestMapping("/article")
public class ArticleService {
    @Autowired
    IArticleFacade articleFacade;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<Article> myArticleList() {

        return this.articleFacade.getAllArticles();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteArticle(@PathVariable("id") Long id) {

        this.articleFacade.deleteMyArticle(id);
    }


    /*@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public boolean deleteArticle(@PathVariable Article myArticle) {

       return this.articleFacade.deleteMyArticle(myArticle);
    }
*/


    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public void saveArticle(@RequestBody Article myArticle) {
        this.articleFacade.saveMyArticle(myArticle);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Article getArticle(@PathVariable("id") Long articleId) {

        return this.articleFacade.getMyArticle(articleId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void updateArticle(@PathVariable("id") Long id ,@RequestBody Article myArticle) {
       myArticle.setId(id);
       this.articleFacade.updateMyArticle(myArticle);
    }

    public IArticleFacade getArticleFacade() {
        return articleFacade;
    }

    public void setArticleFacade(IArticleFacade articleFacade) {
        this.articleFacade = articleFacade;
    }

}
