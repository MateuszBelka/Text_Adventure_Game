package saveAndLoad;

import com.google.gson.Gson;
import initialisation.CollectionOfAllClasses;

import java.io.FileWriter;
import java.io.IOException;

public class SaveToFile {
    /* Receives an instance of CollectionOfAllClasses class
     * which is then serialized and put in JSON file with the name
     * specified in the 2nd parameter of the method.
     *
     * Returns: null; Method is of void type
     */
    private static void writeToFile(CollectionOfAllClasses collection, String fileName) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(collection);

        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write(json);
        fileWriter.close();
    }
}