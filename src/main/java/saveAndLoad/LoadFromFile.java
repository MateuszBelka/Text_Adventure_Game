package saveAndLoad;

import com.google.gson.Gson;
import initialisation.CollectionOfAllClasses;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


/*
 * The following scenario poses an issue to writing Json files using Gson:
 *
 *   public class classA {
 *       public classC foo;
 *   }
 *   public class classB {
 *       public classC foo;
 *   }
 *   public class classC {
 *       int i;
 *   }
 *
 * In a scenario where classA.foo == classB.foo, Gson,
 * while reading Json file would create two new instances of classC
 * and as such change to classA.foo would not be reflected in classB.foo
 *
 * There are multiple ways of approaching this issue.
 * We've decided to solve it by keeping native implementation of Gson,
 * but instead of including variable of other class's type,
 * we will include an int ID which will allow us to locate
 * the desired instances of said class.
 *
 * This divides following loading Json file into two categories:
 * - creating instances of classes with most information
 * - connecting multiple object references to a single object using ID system
 */

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

