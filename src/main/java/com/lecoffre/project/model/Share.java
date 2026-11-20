package com.lecoffre.project.model;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Table(name = "share")
@Entity
public class Share {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "secret_id", nullable = false)
    private Secret secret;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="shared_user_id", nullable = false)
    private Users users;

    @CreationTimestamp
    @Column(name="shared_at", nullable = false, updatable = false)
    private LocalDateTime sharedAt;

    public Share(){}

    public Share(Secret secret, Users users){
        this.secret=secret;
        this.users=users;
    }

    public Long getId() {
        return id;
    }

    public Secret getSecret() {
        return secret;
    }

    public Users getUsers() {
        return users;
    }

    public LocalDateTime getSharedAt() {
        return sharedAt;
    }

    public void setSecret(Secret secret) {
        this.secret = secret;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
