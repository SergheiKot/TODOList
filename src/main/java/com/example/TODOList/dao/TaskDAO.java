package com.example.TODOList.dao;

import com.example.TODOList.hibernate.entities.Task;

import java.util.List;

public interface TaskDAO {
    Task findById(int id);

    void save(Task task);

    void update(Task task);

    void delete(Task task);

    List<Task> findAll();
}
