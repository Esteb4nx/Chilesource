/*
 *  @author Jorge M.
 *  23-10-2021
 */

package com.chilesource.Forowebspring.model;

import javax.persistence.*;

@Entity
//@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int id;
    @Column(name = "category_name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "super_category_id")
    private int superCategoryId;
    @Column(name = "icon_path")
    private String iconPath;

    public Category(int id, String name, String description, int superCategoryId, String iconPath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.superCategoryId = superCategoryId;
        this.iconPath = iconPath;
    }

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

    public int getSuperCategoryId() {
        return superCategoryId;
    }

    public void setSuperCategoryId(int superCategoryId) {
        this.superCategoryId = superCategoryId;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }
}
