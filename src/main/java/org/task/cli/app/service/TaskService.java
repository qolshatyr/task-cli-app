package org.task.cli.app.service;

import org.task.cli.app.model.Task;
import org.task.cli.app.storage.TaskStorage;

import java.time.LocalDate;
import java.util.List;

public class TaskService {
    TaskStorage taskStorage = new TaskStorage();


    public void save(Task task) {
        List<Task> tasks = taskStorage.loadFile();
        int nextId = generateNewId(tasks);
        String todayDate = LocalDate.now().toString();

        task.setId(nextId);
        task.setStatus("ToDo");
        task.setCreatedAt(todayDate);
        task.setUpdatedAt(todayDate);

        tasks.add(task);
        taskStorage.saveFile(tasks);
    }

    public void delete(int id) {
        List<Task> tasks = taskStorage.loadFile();
        boolean found = tasks.removeIf(task -> task.getId() == id);

        if (found) {
            taskStorage.saveFile(tasks);
            System.out.println("[INFO] Deleted task: " + id);
        }
        else {
            System.out.println("[ERROR] Task not found: " + id);
        }

    }

    public void edit(int id, String description) {
        if (updateTask(id, task -> task.setDescription(description))) {
            System.out.println("[INFO] Edited task: " + id);
        }
        else {
            System.out.println("[ERROR] Task not found: " + id);
        }
    }

    public void markEdit(int id, String state) {
        if (updateTask(id, task -> task.setStatus(state))) {
            System.out.println("[INFO] Edited task: " + id);
        }
        else {
            System.out.println("[ERROR] Task not found: " + id);
        }
    }

    private boolean updateTask(int id, java.util.function.Consumer<Task> updater) {
        List<Task> tasks = taskStorage.loadFile();
        boolean found = false;
        for (Task task : tasks) {
            if (task.getId() == id) {
                updater.accept(task); // применяем переданную операцию
                task.setUpdatedAt(LocalDate.now().toString());
                found = true;
                break;
            }
        }
        if (found) {
            taskStorage.saveFile(tasks);
        }
        return found;
    }


    public String listTasks(String filterStatus) {
        List<Task> tasks = taskStorage.loadFile();

        if (tasks.isEmpty()) {
            return "No tasks found";
        }

        StringBuilder builder = new StringBuilder();
        for (Task task : tasks) {
            if (filterStatus.equalsIgnoreCase("all") || task.getStatus().equals(filterStatus)) {
                builder.append(task.toString()).append("================================================\n");
            }
        }

        return builder.isEmpty() ? "No tasks found" : builder.toString();
    }

    private int generateNewId(List<Task> tasks) {
        return tasks.stream()
                .mapToInt(Task::getId)
                .max()
                .orElse(0) + 1;
    }
}
