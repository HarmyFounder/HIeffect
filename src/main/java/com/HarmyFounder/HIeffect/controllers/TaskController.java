package com.HarmyFounder.HIeffect.controllers;

import com.HarmyFounder.HIeffect.models.Task;
import com.HarmyFounder.HIeffect.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    private List<List<Task>> tasks = new ArrayList<>();

    {
        tasks.add(0,taskService.getAllTasksWithStatuses().get(0));
        tasks.add(1,taskService.getAllTasksWithStatuses().get(1));
        tasks.add(2,taskService.getAllTasksWithStatuses().get(2));
        tasks.add(3,taskService.getAllTasksWithStatuses().get(3));

    }

    @GetMapping("/")
    public List<List<Task>> getTasksBoard(){
        return tasks;
    }

    @GetMapping("/{id}")
    public Task getCertainTask(@PathVariable("id") Task task){
        return task;
    }

    @PostMapping("/new")
    public Task createTask(@RequestBody Task task){
        return taskService.create(task);
    }

    @PutMapping("{id}/edit")
    public Task updateTask(@PathVariable("id")Task taskToBeUpdated, @RequestBody Task updatedTask){
        return taskService.update(taskToBeUpdated,updatedTask);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id")Task task){
        taskService.delete(task);
    }

    @PostMapping("/{id}/upgradeTaskStatus")
    public Task upgradeTaskStatus(@PathVariable("id")Task task){
        return taskService.upgradeTaskStatus(task);
    }

    @PostMapping("/{id}/downgradeTaskStatus")
    public Task downgradeTaskStatus(@PathVariable("id") Task task){
        return taskService.downgradeTaskStatus(task);
    }

}
