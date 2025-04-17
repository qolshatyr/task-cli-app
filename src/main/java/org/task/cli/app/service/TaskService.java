package org.task.cli.app.service;

import org.task.cli.app.model.Task;
import org.task.cli.app.storage.TaskStorage;

import java.util.List;

public class TaskService {

    public static void main(String[] args) {
        TaskStorage taskStorage = new TaskStorage();
        List<Task> arr = taskStorage.loadFile();
        System.out.println(arr);;
    }
}
