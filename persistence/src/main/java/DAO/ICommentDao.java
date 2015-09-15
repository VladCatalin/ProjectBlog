package DAO;

import model.Comment;

import java.util.List;

/**
 * Created by CataVlad on 14-Sep-15.
 */
public interface ICommentDao {

    public List<Comment> getAll(Long id);
    public void deleteComment(Long articleId , Long commentId);
    public Comment getComment(Long articleId ,Long commentId);
    public void updateComment(Comment myComment);
    public void saveThisComment(Comment articleId);
}
