package com.chilesource.Forowebspring.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Clase <i>@Entity</i> que representa la tabla <i>commentary</i> respectiva en base de datos
 *
 * @see <a href="https://javadoc.io/doc/jakarta.persistence/jakarta.persistence-api/latest/jakarta.persistence/jakarta/persistence/Entity.html">Entity</a>
 */
@Entity
public class Commentary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentary_id")
    private int id;

    @Column(name = "c_content")
    private String content;

    @Column(name = "c_date")
    private Timestamp date;

    @Column(name = "c_likes")
    private int likes;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User user;


    /**
     * Crea una nueva entidad de tipo Commentary con todos sus atributos
     * @param id identificador auto incremental (NOT NULL)
     * @param content contenido de comentario (NOT NULL)
     * @param date fecha de publicación (NOT NULL)
     * @param likes votos (No implementado aún)
     * @param post post asociado al comentario (NOT NULL)
     * @param user autor del comentario (NOT NULL)
     */
    public Commentary(int id, String content, Timestamp date, int likes, Post post, User user) {
        this.id = id;
        this.content = content;
        this.date = date;
        this.likes = likes;
        this.post = post;
        this.user = user;
    }

    /**
     * Crea una nueva entidad de tipo Commentary sin atributos
     */
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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

