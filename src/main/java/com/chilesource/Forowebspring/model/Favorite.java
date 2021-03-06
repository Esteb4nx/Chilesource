package com.chilesource.Forowebspring.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Clase <i>@Entity</i> que representa la tabla <i>favorite</i> respectiva en base de datos
 *
 * @see <a href="https://javadoc.io/doc/jakarta.persistence/jakarta.persistence-api/latest/jakarta.persistence/jakarta/persistence/Entity.html">Entity</a>
 */
@Entity
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fav_id")
    private int id;

    @Column(name = "fav_date")
    private Timestamp date;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * Crea una nueva entidad de tipo <i>Favorite</i> con todos sus atributos
     * @param id identificador auto incremental (NOT NULL)
     * @param date fecha de creación de <i>Favorite</i> (NOT NULL)
     * @param post <i>Post</i> asociado a este <i>Favorite</i> (NOT NULL)
     * @param user <i>User</i> autor de <i>Favorite</i> (NOT NULL)
     */
    public Favorite(int id, Timestamp date, Post post, User user) {
        this.id = id;
        this.date = date;
        this.post = post;
        this.user = user;
    }

    /**
     * Crea una nueva entidad de tipo <i>Favorite</i> sin atributos
     */
    public Favorite() {
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
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
