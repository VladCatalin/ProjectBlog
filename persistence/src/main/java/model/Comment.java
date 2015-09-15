package model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.*;

/**
 * Created by CataVlad on 14-Sep-15.
 */
@Entity
@Table(name = "comment")
public class Comment {

    @GeneratedValue(generator = "idIncrementor")
    @GenericGenerator(name = "idIncrementor", strategy = "increment")
    @Id
    private Long id;

    @Column(name = "content")
    public String content;

    @Column(name = "articleId")
    private Long articleId;

    private Comment() {
    }

    public Comment(String content, Long articleId) {
        this.content = content;
        this.articleId = articleId;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

