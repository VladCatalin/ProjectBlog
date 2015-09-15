package DAO;

import model.Article;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by CataVlad on 11-Sep-15.
 */
public interface IArticleDao {

    public List<Article> getAll();
    public Article getArticle(Long id);
    public void deleteArticle(Long id);
    public void saveArticle(Article myArticle);
    public void updateArticle(Article myArticle);
}
