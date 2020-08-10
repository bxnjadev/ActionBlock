package team.cloudly.files;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;

public class JsonFile {

    private File file;
    private final File folder;
    private final String fileName;

    public JsonFile(File folder, String fileName){
        this.folder = folder;
        this.fileName = fileName;
        loadFile();
    }

    private void loadFile(){
        file = new File(folder,fileName+".json");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
    }

    public String getJsonText(){
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(fileReader);

        String line = "";

        StringBuilder builder = new StringBuilder();

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
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(jsonText);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFile(JSONObject object){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(object.toJSONString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFile(JSONArray object){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(object.toJSONString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFileName(){
        return fileName;
    }

}
