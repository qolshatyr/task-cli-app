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

    public void isFileExist() throws IOException {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            file.createNewFile();
            Writer writer = new FileWriter(file);
            writer.write("[]");
        }
    }

    public List<Task> loadFile() {
        try {
            isFileExist();
            Reader reader = new FileReader(FILE_PATH);
            Type taskListType = new TypeToken<List<Task>>(){}.getType();
            List<Task> tasks = gson.fromJson(reader, taskListType);
            return tasks != null ? tasks : new ArrayList<Task>();
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return new ArrayList<Task>();
        }
    }

    public void saveFile(List<Task> tasks) {
        try {
            isFileExist();
            Writer writer = new FileWriter(FILE_PATH);
            gson.toJson(tasks, writer);

            System.out.println("Saved tasks to file: " + FILE_PATH);
            writer.close();
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
