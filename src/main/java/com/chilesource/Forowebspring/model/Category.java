package com.chilesource.Forowebspring.model;

import javax.persistence.*;

/**
 * Clase <i>@Entity</i> que representa la tabla <i>category</i> respectiva en base de datos
 *
 * @see <a href="https://javadoc.io/doc/jakarta.persistence/jakarta.persistence-api/latest/jakarta.persistence/jakarta/persistence/Entity.html">Entity</a>
 */
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int id;

    @Column(name = "category_name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "icon_path")
    private String iconPath;

    @ManyToOne
    @JoinColumn(name = "super_category_id")
    private SuperCategory superCategory;

    /**
     * Crea una nueva entidad de tipo <i>Category</i> con todos sus atributos
     * @param id identificador auto incremental (NOT NULL)
     * @param name nombre de categoría (NOT NULL)
     * @param description descripción de categoría
     * @param superCategory super categoría correspondiente (NOT NULL)
     * @param iconPath ruta del ícono
     */
    public Category(int id, String name, String description, SuperCategory superCategory, String iconPath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.superCategory = superCategory;
        this.iconPath = iconPath;
    }

    /**
     * Crea una nueva entidad de tipo <i>Category</i> sin atributos
     */
    public Category() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SuperCategory getSuperCategory() {
        return superCategory;
    }

    public void setSuperCategory(SuperCategory superCategory) {
        this.superCategory = superCategory;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }
}
