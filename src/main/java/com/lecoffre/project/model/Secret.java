package com.lecoffre.project.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Table(name="secret")
@Entity

public class Secret {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Users users;

    @Column(name = "label", length = 100, nullable = false)
    private String label;

    @Column(name="value", nullable = false, columnDefinition = "TEXT")
    private String value;

    public Secret(){}

    public Secret(Users users, String label, String value){
        this.users=users;
        this.label=label;
        this.value=value;
    }

    public Long getId() {
        return id;
    }

    public Users getUsers() {
        return users;
    }

    public String getLabel() {
        return label;
    }

    public String getValue() {
        return value;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
