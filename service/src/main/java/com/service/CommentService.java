package com.service;

import facade.IArticleFacade;
import facade.ICommentFacade;
import model.Article;
import model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by CataVlad on 14-Sep-15.
 */
@Controller
public class CommentService {

    @Autowired
    ICommentFacade commentFacade;

    @RequestMapping(value="/article/{articleId}/comment", method= RequestMethod.GET)
    @ResponseBody
    public List<Comment> getAllComments(@PathVariable("articleId") Long articleId)
    {
        return this.commentFacade.getAllComments(articleId);
    }
    @RequestMapping(value="/article/{articleId}/comment/{commentId}", method= RequestMethod.GET)
    @ResponseBody
    public Comment getComment(@PathVariable("articleId") Long articleId,@PathVariable("commentId") Long commentId) {
        return this.commentFacade.getComment(articleId, commentId);
    }

    @RequestMapping(value="/article/{articleId}/comment/{commentId}", method= RequestMethod.DELETE)
    @ResponseBody
    public void deleteComment(@PathVariable("articleId") Long articleId,@PathVariable("commentId") Long commentId) {
        this.commentFacade.deleteComment(articleId,commentId);
    }


    @RequestMapping(value="/article/{articleId}/comment/", method= RequestMethod.POST)
    @ResponseBody
    public void saveComment(@RequestBody Comment articleId) {
        this.commentFacade.saveComment(articleId);
    }

    @RequestMapping(value = "/article/{articleId}/comment/{commentId}", method = RequestMethod.PUT)
    @ResponseBody
    public void updateArticle(@PathVariable("commentId") Long id ,@PathVariable("articleId") Long articleId,@RequestBody Comment myComment) {
        myComment.setId(id);
        myComment.setArticleId(articleId);
        this.commentFacade.updateComment(myComment);
    }

    public ICommentFacade getCommentFacade() {
        return commentFacade;
    }

    public void setCommentFacade(ICommentFacade commentFacade) {
        this.commentFacade = commentFacade;
    }
}
