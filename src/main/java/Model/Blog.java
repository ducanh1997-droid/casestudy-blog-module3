package Model;

import java.util.Date;

public class Blog  {
    private int id;
    private String title;
    private  String content;
    private Date date;
    private String author;
    private Category category_id;
    private Account account_id;
    private String status;
    private String image;

    public Blog() {
    }

    public Blog(int id, String title, String content, Date date, String author, Category category_id, Account account_id, String status, String image) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.author = author;
        this.category_id = category_id;
        this.account_id = account_id;
        this.status = status;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Category getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Category category_id) {
        this.category_id = category_id;
    }

    public Account getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Account account_id) {
        this.account_id = account_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
