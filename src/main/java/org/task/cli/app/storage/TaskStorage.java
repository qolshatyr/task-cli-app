package org.task.cli.app.storage;


import com.google.gson.Gson;
import org.task.cli.app.model.Task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskStorage {
    private static final String FILE_PATH = "tasks.json";
    private static final Gson gson = new Gson();

    public String isFileExist() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                file.createNewFile();
            }

            return null;
        } catch (IOException e) {
            return "Error: " + e.getMessage();
        }
    }

    public List<Task> loadFile() {
        try {
            Reader reader = new FileReader(FILE_PATH);
            List<Task> tasks = gson.fromJson(reader, List.class);
            return tasks != null ? tasks : new ArrayList<Task>();
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return new ArrayList<Task>();
        }
    }



}
