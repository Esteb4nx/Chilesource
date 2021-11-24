package com.chilesource.Forowebspring.model;

import javax.persistence.*;

/**
 * Clase <i>@Entity</i> que representa la tabla <i>role</i> respectiva en base de datos
 *
 * @see <a href="https://javadoc.io/doc/jakarta.persistence/jakarta.persistence-api/latest/jakarta.persistence/jakarta/persistence/Entity.html">Entity</a>
 */
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int id;

    @Column(name = "role_name")
    private String roleName;

    /**
     * Crea una nueva entidad de tipo <i>Role</i> con todos sus atributos
     * @param id identificador auto incremental (NOT NULL)
     * @param name nombre asignado al rol p.ej. ADMIN, USER, etc. (NOT NULL)
     */
    public Role(int id, String name) {
        this.id = id;
        this.roleName = name;
    }

    /**
     * Crea una nueva entidad de tipo <i>Role</i> sin atributos
     */
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
