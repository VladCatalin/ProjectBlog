package facade;

import DAO.IArticleDao;
import DAO.ICommentDao;
import model.Article;
import model.Comment;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by CataVlad on 14-Sep-15.
 */
public class CommentFacade implements ICommentFacade {

    @Autowired
    private ICommentDao commentDao;

    public List<Comment> getAllComments(Long id) {
        return this.commentDao.getAll(id);
    }

    public void saveComment(Comment articleId) {
        this.commentDao.saveThisComment(articleId);
    }

    public void deleteComment(Long articleId , Long commentId) {
        this.commentDao.deleteComment(articleId, commentId);
    }

    public Comment getComment(Long articleId ,Long commentId) {
        return this.commentDao.getComment(articleId, commentId);
    }

    public void updateComment(Comment myComment){
        this.commentDao.updateComment(myComment);
    }

}
