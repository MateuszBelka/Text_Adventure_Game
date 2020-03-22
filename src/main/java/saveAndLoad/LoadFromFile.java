package saveAndLoad;

import com.google.gson.Gson;
import initialisation.CollectionOfAllClasses;

import java.io.FileReader;
import java.io.IOException;

/*
 * Gson doesn't natively support saving variables which type is of other classes.
 *
 * Example:
 * public class classA {
 *     public classC foo;
 * }
 * public class classB {
 *     public classC foo;
 * }
 * public class classC {
 *     int i;
 * }
 *
 * In scenario where classA.foo == classB.foo
 * Gson would create two unique instances of classC
 * and as such if in the future classA.foo.i would change
 * then this change would not be deflected in classB.foo.i
 *
 * There are multiple approaches to resolving this issue.
 * We decided to implement an ID system in which all classes
 * have IDs and variables which point to object are not included
 * in Json and instead the object's IDs are.
 *
 * During deserialization object references are added manually,
 * using custom ID matching algorithm.
 */

public class LoadFromFile {
    /*
     *
     * Returns: an instance of CollectionOfAllClasses class
     * which contains information required to reconstruct
     * a game from any moment in terms of player's progress.
     */
    public void deserializeJSONFile(String fileName) throws IOException {
        Gson gson = new Gson();

        FileReader loadFile = new FileReader(fileName);
        CollectionOfAllClasses loadedInfoAboutClasses = gson.fromJson(loadFile, CollectionOfAllClasses.class);


    }

    public void debugPrintContentsOfCollectionOfAllClasses(CollectionOfAllClasses object) {
        System.out.println(CollectionOfAllClasses.getPlayer().getCurrentHunger());
    }
}


/*
 * Alternative idea:
 * Create variable for each class and serialize those variables to json.
 * This way you'd create multiple json files. One for each class.
 *
 * Issue: cash instances
 * https://stackoverflow.com/questions/58841054/gson-same-object-referenced-in-two-classes-duplicated-instance-after-decode
 */