package org.educational;

import java.time.LocalDateTime;

public class Task {
    private int id;
    private String description;
    private TaskStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Task() {
    }

    public Task(String description) {
        this.description = description;
    }
/*
    { "id": 1,
      "description": "teste 1",
      "status": TODO,
      "createdAt": "2026-06-23T17:01:39.883283100",
      "updatedAt": "2026-06-23T17:01:39.883283100" }
 */
    public static void getTaskFromString(String jsonTask){
        // função que destrincha a string procurando informações para criar uma tarefa.
    }

    public static Task createTask(String taskDescription) {
        Task task = new Task();
        task.setId(0);
        task.setDescription(taskDescription);
        task.setStatus(TaskStatus.TODO);
        task.createdAt = LocalDateTime.now();
        task.updatedAt = LocalDateTime.now();
        return task;
    }

    @Override
    public String toString() {
        return "{\"id\":"+this.id+"," +
                "\"description\":\""+this.description+"\"," +
                "\"status\":"+this.status+"," +
                "\"createdAt\":\""+this.createdAt+"\"," +
                "\"updatedAt\":\""+this.updatedAt+"\"}";
    }
}
