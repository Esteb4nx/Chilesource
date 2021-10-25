/*
 *  @author Jorge M.
 *  24-10-2021
 */

package com.chilesource.Forowebspring.model;

import javax.persistence.*;

@Entity
@Table(name = "super_category")
public class SuperCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scategory_id")
    private int id;

    @Column(name = "scategory_name")
    private String name;

    public SuperCategory(int id, String name) {
        this.id = id;
        this.name = name;
    }

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
