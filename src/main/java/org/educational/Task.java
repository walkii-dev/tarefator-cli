package org.educational;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

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


    public static Task getTaskFromString(String jsonTask) {
        Task t = new Task();

        List<String> taskProperties = Arrays.stream(jsonTask.split(",")).toList();

        t.setId(Integer.parseInt(taskProperties.get(0).split(":")[1].trim()));
        t.setDescription(taskProperties.get(1).split(":")[1].trim());
        t.setStatus(TaskStatus.valueOf(taskProperties.get(2).split(":")[1].trim())); // melhorar esse enum
        t.setCreatedAt(LocalDateTime.parse(taskProperties.get(3).split("\":")[1].replace("}", "").trim()));
        t.setUpdatedAt(LocalDateTime.parse(taskProperties.get(4).split("\":")[1].replace("}", "").trim()));
        return t;
    }

    public static Task createTask(String taskDescription) {
        Task task = new Task();
        task.setId(0);
        task.setDescription(taskDescription.replace("\"",""));
        task.setStatus(TaskStatus.TODO);
        task.createdAt = LocalDateTime.now();
        task.updatedAt = LocalDateTime.now();
        return task;
    }

    @Override
    public String toString() {
        return "{\"id\":" + this.id + "," +
                "\"description\":" + this.description + "," +
                "\"status\":" + this.status + "," +
                "\"createdAt\":" + this.createdAt + "," +
                "\"updatedAt\":" + this.updatedAt + "}";
    }
}
