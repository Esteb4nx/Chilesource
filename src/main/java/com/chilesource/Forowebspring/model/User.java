package com.chilesource.Forowebspring.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Clase <i>@Entity</i> que representa la tabla <i>user</i> respectiva en base de datos
 *
 * @see <a href="https://javadoc.io/doc/jakarta.persistence/jakarta.persistence-api/latest/jakarta.persistence/jakarta/persistence/Entity.html">Entity</a>
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_email")
    private String email;

    @Column(name = "profile_description")
    private String profileDescription;

    @Column(name = "profile_picture")
    private String profilePicture;

    // FIXME: revisar este campo, roles serán hardcodeados hasta entonces
    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    /**
     * Crea una nueva entidad de tipo <i>User</i> con todos sus atributos
     * @param id identificador auto incremental (NOT NULL)
     * @param userName nombre de <i>User</i> (NOT NULL)
     * @param password contraseña (NOT NULL)
     * @param email correo electrónico
     * @param roles conjunto de roles asignados a este <i>User</i>
     */
    public User(int id, String userName, String password, String email, Set<Role> roles) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }

    /**
     * Crea una nueva entidad de tipo <i>User</i> sin atributos
     */
    public User() {
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> role) {
        this.roles = role;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profile_description) {
        this.profileDescription = profile_description;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profile_picture) {
        this.profilePicture = profile_picture;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", profile_description='" + profileDescription + '\'' +
                ", profile_picture='" + profilePicture + '\'' +
                ", roles=" + roles +
                '}';
    }
}
