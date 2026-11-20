package com.lecoffre.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Table(name="secret")
@Entity

public class Secret {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Users owner;

    @NotBlank
    @Size(max = 100)
    @Column(name = "label", length = 100, nullable = false)
    private String label;

    @NotBlank
    @Column(name="value", nullable = false, columnDefinition = "TEXT")
    private String value;

    public Secret(){}

    public Secret(Users owner, String label, String value){
        this.owner=owner;
        this.label=label;
        this.value=value;
    }

    public Long getId() {
        return id;
    }

    public Users getOwner() {
        return owner;
    }

    public String getLabel() {
        return label;
    }

    public String getValue() {
        return value;
    }

    public void setOwner(Users owner) {
        this.owner = owner;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
