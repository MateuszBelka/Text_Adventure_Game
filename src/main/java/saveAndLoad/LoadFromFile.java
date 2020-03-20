package saveAndLoad;

import com.google.gson.Gson;
import initialisation.CollectionOfAllClasses;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
//import com.google.gson.Gson;

public class LoadFromFile {
    public CollectionOfAllClasses readFromFile(String fileName) throws IOException {
        File savefile = new File (fileName);

        List fileList = Files.readAllLines(Paths.get(savefile.getAbsolutePath()), StandardCharsets.US_ASCII);
        String jsonString = fileList.toString();

        jsonString = deleteFirstAndLastCharOfString(jsonString);

        return deserialize(jsonString);
    }

    private String deleteFirstAndLastCharOfString (String text){
        StringBuilder stringBuilder = new StringBuilder(text);
        stringBuilder.deleteCharAt(0);
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }

    private CollectionOfAllClasses deserialize(String jsonFile) {
        Gson gson = new Gson();
        return gson.fromJson(jsonFile, CollectionOfAllClasses.class);
    }
}

