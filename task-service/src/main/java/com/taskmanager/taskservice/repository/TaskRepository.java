package com.taskmanager.taskservice.repository;

import com.taskmanager.taskservice.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
