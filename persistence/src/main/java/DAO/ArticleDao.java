package DAO;

import model.Article;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.xml.ws.RequestWrapper;
import java.util.List;

/**
 * Created by CataVlad on 11-Sep-15.
 */
public class ArticleDao implements IArticleDao {

    private EntityManager entityManager;


    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Article> getAll() {
        return this.entityManager.createQuery("from Article").getResultList();
    }

    @Transactional
    public void deleteArticle(Long id) {
        Article itemFromDbs = this.getArticle(id);
        //Article itemFromDbs = entityManager.find(Article.class, id);
        if (itemFromDbs != null) {
            entityManager.remove(itemFromDbs);
        }
    }

    @Transactional
    public Article getArticle(Long id) {
        if (id == null) {
            throw new EntityNotFoundException("Can't find Article for ID "
                    + id);
        } else {
            return entityManager.find(Article.class, id);
        }
    }

    @Transactional
     public void saveArticle(Article myArticle) {
        entityManager.persist(myArticle);


    }

    @Transactional
    public void updateArticle(Article myArticle) {
        Article itemFromDbs = this.getArticle(myArticle.getId());
        if (itemFromDbs != null) {

            itemFromDbs.setTitle(myArticle.getTitle());
            itemFromDbs.setDescription(myArticle.getDescription());
            itemFromDbs.setContent(myArticle.getContent());
            entityManager.persist(itemFromDbs);
        }

    }

}


