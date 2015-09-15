package facade;

import DAO.IArticleDao;
import model.Article;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by CataVlad on 11-Sep-15.
 */
public class ArticleFacade implements IArticleFacade {

    @Autowired
    private IArticleDao articleDao;

    public IArticleDao getArticleDao() {
        return articleDao;
    }

    public void setArticleDao(IArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    public List<Article> getAllArticles() {
        return this.articleDao.getAll();
    }

    public void deleteMyArticle(Long id) {
        this.articleDao.deleteArticle(id);
    }


    public void saveMyArticle(Article myArticle) {
        this.articleDao.saveArticle(myArticle);
    }

    public Article getMyArticle(Long id) {
        return this.articleDao.getArticle(id);
    }

    public  void updateMyArticle(Article myArticle) {
      this.articleDao.updateArticle(myArticle);
    }
}
