package com.HarmyFounder.HIeffect.services;

import com.HarmyFounder.HIeffect.models.Task;
import com.HarmyFounder.HIeffect.models.TaskStatus;
import com.HarmyFounder.HIeffect.repositories.TaskRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    Map<Integer, TaskStatus> statuses = new HashMap<>();

    {
        statuses.put(0,TaskStatus.NO_STATUS);
        statuses.put(1,TaskStatus.NEXT_UP);
        statuses.put(2,TaskStatus.IN_PROGRESS);
        statuses.put(3,TaskStatus.COMPLETED);
    }

    Map<Integer, List<Task>> allTasksWithStatuses = new HashMap<>();

    {
        allTasksWithStatuses.put(0, taskRepository.findByTaskStatus(TaskStatus.NO_STATUS));
        allTasksWithStatuses.put(1, taskRepository.findByTaskStatus(TaskStatus.NEXT_UP));
        allTasksWithStatuses.put(2, taskRepository.findByTaskStatus(TaskStatus.IN_PROGRESS));
        allTasksWithStatuses.put(3, taskRepository.findByTaskStatus(TaskStatus.COMPLETED));
    }

    public List<Task> getAll(){
        return taskRepository.findAll();
    }

    public Task create(Task task) {
        return taskRepository.save(task);
    }

    public Task update(Task taskToBeUpdated, Task updatedTask){
        BeanUtils.copyProperties(updatedTask,taskToBeUpdated,"id");
        return taskRepository.save(taskToBeUpdated);
    }

    public void delete(Task task){
        taskRepository.delete(task);
    }

    public Task upgradeTaskStatus(Task task){
        task.setTaskStatus(statuses.get(task.getStatusKey() + 1));
        return taskRepository.save(task);
    }

    public Task downgradeTaskStatus(Task task){

        if(task.getTaskStatus().getStatus().equals(statuses.get(0).getStatus())){
            return task;
        } else {
            task.setTaskStatus(statuses.get(task.getStatusKey() - 1));
            return taskRepository.save(task);
        }

    }

    public Map<Integer, List<Task>> getAllTasksWithStatuses() {
        return allTasksWithStatuses;
    }


}
