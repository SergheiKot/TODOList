package com.example.TODOList.controllers;

import com.example.TODOList.hibernate.entities.Task;
import com.example.TODOList.services.TaskService;
import javassist.NotFoundException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ApiController {

    private TaskService taskService = new TaskService();

    @GetMapping
    public ResponseEntity getAll() {
        List<Task> taskList = taskService.findAllTasks();
        try {
            JSONObject answer = new JSONObject();
            taskList.forEach(x -> {
                answer.append(Integer.toString(x.getId()), x.getTask());
            });
            return ResponseEntity.ok(answer.toString());
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity getOne(@PathVariable int id) throws NotFoundException {

        Task task = taskService.findTask(id);
        try {
            JSONObject answer = new JSONObject().append("" + id, task.getTask());
            return ResponseEntity.ok(answer.toString());
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public void create(@RequestBody String task) {
        Task dbTask = new Task(task);
        taskService.saveTask(dbTask);
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable int id, @RequestBody String task) {
        Task dbTask = taskService.findTask(id);

        if (dbTask == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        dbTask.setTask(task);
        taskService.updateTask(dbTask);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable int id) {
        Task dbTask = taskService.findTask(id);

        if (dbTask == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        taskService.deleteTask(dbTask);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
