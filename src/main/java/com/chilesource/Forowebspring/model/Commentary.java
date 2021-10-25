/*
 *  @author Jorge M.
 *  25-10-2021
 */

package com.chilesource.Forowebspring.model;


import javax.persistence.*;
import java.sql.Date;

@Entity
public class Commentary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentary_id")
    private int id;

    @Column(name = "c_content")
    private String content;

    @Column(name = "c_date")
    private Date date;

    @Column(name = "c_likes")
    private int likes;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Commentary(int id, String content, Date date, int likes, Post post) {
        this.id = id;
        this.content = content;
        this.date = date;
        this.likes = likes;
        this.post = post;
    }

    public Commentary() {
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}

