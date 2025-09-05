package com.app.apnatodo.reposiotory;

import com.app.apnatodo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
