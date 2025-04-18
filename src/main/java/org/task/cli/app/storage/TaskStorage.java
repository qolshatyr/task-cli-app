package org.task.cli.app.storage;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.task.cli.app.model.Task;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TaskStorage {
    private static final String FILE_PATH = "tasks.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final Type TASK_LIST_TYPE = new TypeToken<List<Task>>(){}.getType();


    public void isFileExist() throws IOException {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            initializeFile(file);
        }
    }

    public void initializeFile(File file) throws IOException {
        file.createNewFile();
        try (Writer writer = new FileWriter(file)) {
            writer.write("[]");
        }
    }

    public List<Task> loadFile() {
        try {
            isFileExist();
            try (Reader reader = new FileReader(FILE_PATH)) {
                List<Task> tasks = gson.fromJson(reader, TASK_LIST_TYPE);
                return tasks != null ? tasks : new ArrayList<>();
            }
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public void saveFile(List<Task> tasks) {
        try {
            isFileExist();
            try (Writer writer = new FileWriter(FILE_PATH)) {
                gson.toJson(tasks, writer);
            }
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
