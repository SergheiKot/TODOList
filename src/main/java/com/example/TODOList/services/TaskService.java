package com.example.TODOList.services;

import com.example.TODOList.dao.TaskDAO;
import com.example.TODOList.dao.TaskDAOImpl;
import com.example.TODOList.hibernate.entities.Task;

import java.util.List;

public class TaskService {
    private TaskDAO taskDAO = new TaskDAOImpl();

    public TaskService() {}

    public Task findTask(int id) {
        return taskDAO.findById(id);
    }

    public void saveTask(Task task) {
        taskDAO.save(task);
    }

    public void deleteTask(Task task) {
        taskDAO.delete(task);
    }

    public void updateTask(Task task) {
        taskDAO.update(task);
    }

    public List<Task> findAllTasks() {
        return taskDAO.findAll();
    }
}
