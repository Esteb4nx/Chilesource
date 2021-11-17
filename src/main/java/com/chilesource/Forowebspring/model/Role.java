/*
 *  @author Jorge M.
 *  25-10-2021
 */

package com.chilesource.Forowebspring.model;

import javax.persistence.*;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int id;

    @Column(name = "role_name")
    private String roleName;

    public Role(int id, String name) {
        this.id = id;
        this.roleName = name;
    }

    public Role() {
    }

    // Getter y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String name) {
        this.roleName = name;
    }
}
