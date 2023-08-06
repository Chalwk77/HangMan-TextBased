package com.chalwk;

import org.json.JSONObject;

import java.io.*;

public class FileIO {

    static String programPath = getProgramPath();

    private static void checkExists(File file) throws IOException {
        boolean exists = file.exists();
        if (!exists) {
            boolean created = file.createNewFile();
            if (!created) {
                throw new IOException("Failed to create file: " + file);
            }
        }
    }

    public static String getProgramPath() {
        String currentDirectory = System.getProperty("user.dir");
        currentDirectory = currentDirectory.replace("\\", "/");
        return currentDirectory + "/";
    }

    public static String readFile(String fileName) throws IOException {

        File f = new File(programPath + fileName);
        checkExists(f);

        BufferedReader reader = new BufferedReader(new FileReader(f));
        String line = reader.readLine();
        StringBuilder stringBuilder = new StringBuilder();

        while (line != null) {
            stringBuilder.append(line);
            line = reader.readLine();
        }
        reader.close();

        return stringBuilder.toString();
    }

    public static JSONObject readJSONObject(String fileName) throws IOException {
        String content = readFile(fileName);
        return content.isEmpty() ? new JSONObject() : new JSONObject(content);
    }
}
