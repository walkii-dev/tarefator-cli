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


    public Task(String description){
        this.id = 1;
        this.description= description;
        this.status =TaskStatus.TODO;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = createdAt;
    }

    public static void createTask(String taskDescription) {



        System.out.println(String.format("task \"%s\" created successfully!",taskDescription));
    }

    @Override
    public String toString() {
        return "{ \"id\": "+this.id+"," +
                " \"description\": "+this.description+"," +
                " \"status\": "+this.status+"," +
                " \"createdAt\": "+this.createdAt+"," +
                " \"updatedAt\": "+this.updatedAt+" }";
    }
}
