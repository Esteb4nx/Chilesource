/*
 *  @author Jorge M.
 *  25-10-2021
 */

package com.chilesource.Forowebspring.model;

import javax.persistence.*;
import java.sql.Timestamp;



@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name  = "post_id")
    private int id;

    @Column(name = "post_title")
    private String title;

    @Column(name = "post_body")
    private String body;

    @Column(name = "post_date")
    private Timestamp date;

    @ManyToOne
    @JoinColumn(name = "post_category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    public Post(int id, String title, String body, Timestamp date, Category category, User author) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.date = date;
        this.category = category;
        this.author = author;
    }

    public Post() {
    }

    // Getters y setters
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
