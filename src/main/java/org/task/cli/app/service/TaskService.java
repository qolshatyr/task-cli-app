package org.task.cli.app.service;

import org.task.cli.app.model.Task;
import org.task.cli.app.storage.TaskStorage;

import java.time.LocalDate;
import java.util.List;

public class TaskService {
    public void save(Task task) {
        TaskStorage taskStorage = new TaskStorage();
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
    private int generateNewId(List<Task> tasks) {
        return tasks.stream()
                .mapToInt(Task::getId)
                .max()
                .orElse(0) + 1;
    }
}
