package input.commands;

import output.NonStoryPrinter;
import saveAndLoad.Save;

import java.io.File;
import java.net.URISyntaxException;

public class DoSave {
    public static void doSave() throws URISyntaxException {
        String path = new File(DoSave.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath();

        String projectPath = path.substring(path.length() - 23);
        // Different absolute path for IDE and for JAR
        if (projectPath.equals("build\\classes\\java\\main")) { // IDE
            path = path.substring(0, path.length() - 23);
        } else { // JAR
            path = path.substring(0, path.length() - 38);

        }

        path += "build\\resources\\saves\\save0.json";

        Save.writeGameSave(path);
        NonStoryPrinter.print("Game has been successfully saved!");
    }

    public static void doAutoSave() throws URISyntaxException {
        String path = new File(DoSave.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath();

        String projectPath = path.substring(path.length() - 23);
        // Different absolute path for IDE and for JAR
        if (projectPath.equals("build\\classes\\java\\main")) { // IDE
            path = path.substring(0, path.length() - 23);
        } else { // JAR
            path = path.substring(0, path.length() - 38);

        }

        path += "resources\\saves\\autosave.json";

        Save.writeGameSave(path);
        NonStoryPrinter.print("Autosave completed!");
    }

    private DoSave(){} //hiding the implicit public constructor
}
