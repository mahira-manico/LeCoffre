package com.lecoffre.project.model;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "access_log")
public class AccessLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "secret_id", nullable = false)
    private Secret secret;

    @Enumerated(EnumType.STRING)
    @Column(name = "result", nullable = false, length = 20)
    private Result result;

    @CreationTimestamp
    @Column(name = "consulted_at", nullable = false, updatable = false)
    private LocalDateTime consultedAt;

    public AccessLog(){}

    public AccessLog(Users users, Secret secret, Result result){
        this.users=users;
        this.secret=secret;
        this.result=result;
    }

    public Long getId() {
        return id;
    }

    public Users getUsers() {
        return users;
    }

    public Secret getSecret() {
        return secret;
    }

    public Result getResult() {
        return result;
    }

    public LocalDateTime getConsultedAt() {
        return consultedAt;
    }

    public void setUsers(Users users) {
        this.users= users;
    }

    public void setSecret(Secret secret) {
        this.secret= secret;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
