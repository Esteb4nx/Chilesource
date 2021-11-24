package com.chilesource.Forowebspring.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Clase <i>@Entity</i> que representa la tabla <i>post</i> respectiva en base de datos
 *
 * @see <a href="https://javadoc.io/doc/jakarta.persistence/jakarta.persistence-api/latest/jakarta.persistence/jakarta/persistence/Entity.html">Entity</a>
 */
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

    /**
     * Crea una nueva entidad de tipo <i>Post</i> con todos sus atributos
     * @param id identificador auto incremental (NOT NULL)
     * @param title título asignado a este <i>Post</i> (NOT NULL)
     * @param body contenido o cuerpo (NOT NULL)
     * @param date fecha de creación (NOT NULL)
     * @param category categoría asociada (NOT NULL)
     * @param author autor (NOT NULL)
     */
    public Post(int id, String title, String body, Timestamp date, Category category, User author) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.date = date;
        this.category = category;
        this.author = author;
    }

    /**
     * Crea una nueva entidad de tipo <i>Post</i> sin atributos
     */
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
