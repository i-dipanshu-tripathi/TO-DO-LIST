package com.app.apnatodo.controller;


import com.app.apnatodo.entity.Task;
import com.app.apnatodo.services.TaskServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TaskController {
    private final TaskServices taskServices;

    public TaskController(TaskServices taskServices){
        this.taskServices = taskServices;
    }

    @GetMapping("/")
    public String viewTasks(Model model){
        List<Task> allTasks = taskServices.getAllTasks();
        model.addAttribute("tasks",allTasks);
        return "tasks";
    }

    @PostMapping("/")
    public String addTask(String title,String description){
        taskServices.createTask(title,description);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable int id){
        taskServices.deleteTask(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable int id){
        taskServices.toggleTask(id);
        return "redirect:/";
    }

}
