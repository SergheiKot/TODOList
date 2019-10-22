package com.example.TODOList.controllers;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class ApiController {

    @GetMapping
    public String getAll() {
        return "Test";
    }

    @GetMapping("{id}")
    public String getOne(@PathVariable String id) {
        JSONObject answer = new JSONObject().append(id, "Task");
        return answer.toString();
    }

    @PostMapping
    public String create(@RequestBody String task) {
        return "Post: " + task;
    }

    @PutMapping("{id}")
    public String update(@PathVariable String id, @RequestBody String task) {
        return "Put: " + id + "\n" + task;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {

    }
}
