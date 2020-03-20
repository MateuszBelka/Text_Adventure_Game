package saveAndLoad;

import initialisation.CollectionOfAllClasses;

import java.io.FileWriter;
import java.io.IOException;

public class SaveToFile {
    private static void writeToFile(CollectionOfAllClasses collection, String fileName) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(collection);

        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write(json);
        fileWriter.close();
    }
}