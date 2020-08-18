package team.cloudly.files;

import com.google.gson.JsonElement;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class JsonFile {

    private final File file;
    private final String fileName;

    public JsonFile(File folder, String fileName){
        this.fileName = fileName;
        file = new File(folder,fileName+".json");
        createFileIfNotExists();
    }

    private void createFileIfNotExists(){
        if(!file.exists()){
            createFile();
        }
    }

    private void createFile(){
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedReader getBufferedReaderFile(){
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new BufferedReader(fileReader);
    }

    public String getJsonText(){
        String line = "";

        StringBuilder builder = new StringBuilder();
        BufferedReader reader = getBufferedReaderFile();

        try {
            while((line = reader.readLine()) != null){
                builder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public void writeFile(String jsonText) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(jsonText);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFile(JsonElement object){
        writeFile(object.getAsString());
    }

    public String getFileName(){
        return fileName;
    }
}
