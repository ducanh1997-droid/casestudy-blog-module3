package Model;

import java.time.LocalDate;
import java.util.Date;

public class Blog  {
    private int id;
    private String title;
    private  String content;
    private LocalDate date;
    private String author;
    private Category category;
    private Account account;
    private String status;
    private String image;

    public Blog() {
    }

    public Blog(int id, String title, String content, LocalDate date, String author, Category category, Account account, String status, String image) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.author = author;
        this.category = category;
        this.account = account;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory_id(Category category_id) {
        this.category = category_id;
    }

    public Account getAccount_id() {
        return account;
    }

    public void setAccount_id(Account account_id) {
        this.account = account_id;
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
