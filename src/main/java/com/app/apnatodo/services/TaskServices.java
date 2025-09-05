package com.app.apnatodo.services;

import com.app.apnatodo.entity.Task;
import com.app.apnatodo.reposiotory.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServices {
    private TaskRepository taskRepository;

    public TaskServices(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public void createTask(String title,String description){
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setCompleted(false);
        taskRepository.save(task);
    }

    public void deleteTask(int id){
        taskRepository.deleteById(id);
    }

    public void toggleTask(int id){
        Task task = taskRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No task found with id: "+id));
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }

}
