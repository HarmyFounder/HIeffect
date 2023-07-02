package com.HarmyFounder.HIeffect.models;

import jakarta.persistence.*;

@Entity
@Table
public class Habit {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String tag;
    private boolean isDone;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
