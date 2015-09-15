package DAO;

import model.Article;
import model.Comment;


import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by CataVlad on 14-Sep-15.
 */
public class CommentDao implements ICommentDao {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Comment> getAll(Long articleId) {

        Query query = this.entityManager.createQuery("from Comment WHERE articleId = :targetArticleId");
        query.setParameter("targetArticleId" , articleId);
        return query.getResultList();}



    @Transactional
    public void deleteComment(Long articleId , Long commentId) {
        Comment itemFromDbs = this.getComment(articleId, commentId);
        //Article itemFromDbs = entityManager.find(Article.class, id);
        if (itemFromDbs != null) {
            entityManager.remove(itemFromDbs);
        }
    }



    @Transactional
    public Comment getComment(Long articleId,Long commentId) {
        if(articleId !=null || commentId != null)
        {
            Query query = this.entityManager.createQuery("from Comment WHERE articleId = :targetArticleId AND id = :targetCommentId ");
            query.setParameter("targetArticleId" , articleId);
            query.setParameter("targetCommentId" , commentId);
            List<Comment> result = query.getResultList();
            if (!result.isEmpty()) {
                return result.get(0);
            }

        }
        return null;
    }

    @Transactional
    public void saveThisComment(Comment articleId)
    {
        entityManager.persist(articleId);
    }

    public Comment getCommentbyId (Long commentId)
    {
        return this.entityManager.find(Comment.class,commentId);
    }

    @Transactional
    public void updateComment(Comment myComment){
        Comment itemFromDbs = this.getCommentbyId(myComment.getId());
        if (itemFromDbs != null) {

            itemFromDbs.setContent(myComment.getContent());
            itemFromDbs.setArticleId(myComment.getArticleId());
            entityManager.persist(itemFromDbs);
        }
    }




    }

