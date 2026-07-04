package org.educational;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


public class Task {
    private int id;
    private String description;
    private TaskStatus status;
//    private final String[] tstatus = {"done","in progress","todo"}; isso pode ser um array primitivo ao inves de enum.
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

    public static void deleteTask(List<Task> taskList, int idNumber) {
        for (Task t : taskList) {
            if (t.id == idNumber) {
                System.out.printf("task %s removed with success.\n", t.getDescription());
                taskList.remove(t);
                return;
            }
        }
        System.out.println("id not found, please input a valid id of task.");
    }

    public static void editTask(List<Task> taskList, int idNumber, String description) {
        for (Task t : taskList) {
            if (t.id == idNumber) {
                t.setDescription(description);
                t.setUpdatedAt(LocalDateTime.now());
                System.out.printf("task %d is updated with success.\n" +
                        "the task is now \"%s\".\n", t.id, t.description);
                return;
            }
        }
        System.out.println("id not found, please input a valid id of task.");
    }

    public static void markTask(List<Task> taskList, int idNumber, TaskStatus status) {
        for (Task t : taskList) {
            if (t.id == idNumber) {
                if (t.status.equals(TaskStatus.DONE)) {
                        System.out.println("this task cannot be changed because the task is done.");
                        return;
                } else {
                    t.setStatus(status);
                    t.setUpdatedAt(LocalDateTime.now());
                    System.out.printf("now the task \"%s\" is %s.\n", t.id, t.status.toString());
                }
            }
        }
    }

    public static Task getTaskFromString(String jsonTask) {
        Task t = new Task();

        List<String> taskProperties = Arrays.stream(jsonTask.split(",")).toList();

        t.setId(
                Integer.parseInt(taskProperties.get(0)
                        .split(":")[1]
                        .trim()));
        t.setDescription(
                taskProperties.get(1)
                        .split(":")[1]
                        .replace("\"", "")
                        .trim());
        t.setStatus(
                TaskStatus.valueOf(taskProperties.get(2)
                        .split(":")[1]
                        .replace("\"", "")
                        .trim())); // melhorar esse enum
        t.setCreatedAt(
                LocalDateTime.parse(taskProperties.get(3)
                        .split("\":")[1]
                        .replace("}", "")
                        .replace("\"", "")
                        .trim()));
        t.setUpdatedAt(
                LocalDateTime.parse(taskProperties.get(4)
                        .split("\":")[1]
                        .replace("}", "")
                        .replace("\"", "")
                        .replace("]", "")
                        .trim()));
        return t;
    }

    public Task(String taskDescription, int counter) {
        this.setId(counter);
        this.setDescription(taskDescription);
        this.setStatus(TaskStatus.TODO);
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "{\"id\":" + this.id + "," +
                "\"description\":\"" + this.description + "\"," +
                "\"status\":\"" + this.status + "\"," +
                "\"createdAt\":\"" + this.createdAt + "\"," +
                "\"updatedAt\":\"" + this.updatedAt + "\"}";
    }
}
