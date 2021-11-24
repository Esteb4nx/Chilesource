package com.chilesource.Forowebspring.model;

import javax.persistence.*;

/**
 * Clase <i>@Entity</i> que representa la tabla <i>super_category</i> respectiva en base de datos
 *
 * @see <a href="https://javadoc.io/doc/jakarta.persistence/jakarta.persistence-api/latest/jakarta.persistence/jakarta/persistence/Entity.html">Entity</a>
 */
@Entity
@Table(name = "super_category")
public class SuperCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scategory_id")
    private int id;

    @Column(name = "scategory_name")
    private String name;

    /**
     * Crea una nueva entidad de tipo <i>SuperCategory</i> con todos sus atributos
     * @param id identificador auto incremental (NOT NULL)
     * @param name nombre asignado (NOT NULL)
     */
    public SuperCategory(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Crea una nueva entidad de tipo <i>SuperCategory</i> sin atributos
     */
    public SuperCategory() {
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
