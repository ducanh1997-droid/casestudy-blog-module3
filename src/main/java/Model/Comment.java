package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Comment {
    private  int id;
    private String content;

    public String getContent() {
        return content;
    }
    public LocalDateTime createAT;

    public void setContent(String content) {
        this.content = content;
    }

    private int blog_id;
    private int account_id;
    private int comment_id;

    public Comment(int id, String content, LocalDateTime createAT, int blog_id, int account_id, int comment_id) {
        this.id = id;
        this.content = content;
        this.createAT = createAT;
        this.blog_id = blog_id;
        this.account_id = account_id;
        this.comment_id = comment_id;
    }

    public Comment(String content, LocalDateTime createAT, int blog_id, int account_id, int comment_id) {
        this.content = content;
        this.createAT = createAT;
        this.blog_id = blog_id;
        this.account_id = account_id;
        this.comment_id = comment_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public void setCreateAT(LocalDateTime createAT) {
        this.createAT = createAT;
    }

    public int getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(int blog_id) {
        this.blog_id = blog_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public LocalDateTime getCreateAT() {
        return createAT;
    }
}
