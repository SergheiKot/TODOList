package com.example.TODOList.hibernate.entities;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "task")
    private String task;

    public Task() {}

    public Task(String task) {
        this.task = task;
    }

    public Task(int id) {
        this.id = id;
    }

    public Task(int id, String task) {
        this.id = id;
        this.task = task;
    }

    public int getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setId(int id) {
        this.id = id;
    }
}
