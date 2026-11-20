package com.lecoffre.project.model;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "email", nullable = false, length = 255, unique = true)
    private String email;

    @Column(name="password", nullable = false, length = 255)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name="role", nullable = false, length = 20)
    private Role role;

    public Users(){}

    public Users(String email, String password, Role role){
        this.email=email;
        this.password=password;
        this.role=role;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
