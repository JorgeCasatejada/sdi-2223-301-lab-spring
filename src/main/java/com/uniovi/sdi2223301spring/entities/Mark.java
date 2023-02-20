package com.uniovi.sdi2223301spring.entities;

import javax.persistence.*;

@Entity
public class Mark {
    @Id @GeneratedValue
    private Long id;
    private String email;
    private Double score;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    public Mark() {
    }

    public Mark(String email, Double score, User user) {
        this.id = id;
        this.email = email;
        this.score = score;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", score=" + score +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
