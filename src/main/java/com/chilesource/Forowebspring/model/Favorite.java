/*
 *  @author Jorge M.
 *  25-10-2021
 */

package com.chilesource.Forowebspring.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fav_id")
    private int id;

    @Column(name = "fav_date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Favorite(int id, Date date, Post post, User user) {
        this.id = id;
        this.date = date;
        this.post = post;
        this.user = user;
    }

    public Favorite() {
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}