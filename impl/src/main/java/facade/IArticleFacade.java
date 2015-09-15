package facade;

import model.Article;

import java.util.List;

/**
 * Created by CataVlad on 11-Sep-15.
 */
public interface IArticleFacade {
   public List<Article> getAllArticles();
   public Article getMyArticle(Long id);
   public void deleteMyArticle(Long id);
   public void saveMyArticle(Article myArticle);
   public void updateMyArticle(Article myArticle);
   /* public boolean deleteMyArticle(int id);*/
}
