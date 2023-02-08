package Model;

public class Comment {
    private  int id;
    private Blog blog_id;
    private Account account_id;
    private Comment comment_id;

    public Comment() {
    }

    public Comment(Blog blog_id, Account account_id, Comment comment_id) {
        this.blog_id = blog_id;
        this.account_id = account_id;
        this.comment_id = comment_id;
    }

    public Comment(int id, Blog blog_id, Account account_id, Comment comment_id) {
        this.id = id;
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

    public Blog getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(Blog blog_id) {
        this.blog_id = blog_id;
    }

    public Account getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Account account_id) {
        this.account_id = account_id;
    }

    public Comment getComment_id() {
        return comment_id;
    }

    public void setComment_id(Comment comment_id) {
        this.comment_id = comment_id;
    }
}