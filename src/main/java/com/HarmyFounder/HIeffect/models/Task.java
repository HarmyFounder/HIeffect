package com.HarmyFounder.HIeffect.models;

import jakarta.persistence.*;

@Entity
public class Task {




    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;
    private String tag;
    private TaskStatus taskStatus;
    private int statusKey;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    public Task() {
    }

    public Task(String title, String description, String tag, TaskStatus status) {
        this.title = title;
        this.description = description;
        this.tag = tag;
        this.taskStatus = status;
    }

    public int getStatusKey() {
        return statusKey;
    }

    public void setStatusKey(int statusKey) {
        this.statusKey = statusKey;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus status) {
        this.taskStatus = status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
