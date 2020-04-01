package input.commands;

import output.InteractionPrinter;
import saveAndLoad.Save;

import java.io.File;
import java.net.URISyntaxException;

public class DoSave {
    public static void doSave() throws URISyntaxException {
        saveLogic("save0");
        InteractionPrinter.print("Game has been successfully saved!");
    }

    public static void doAutoSave() throws URISyntaxException {
        saveLogic("autosave");
        InteractionPrinter.print("Autosave completed!");
    }

    private static void saveLogic(String jsonFileName) throws URISyntaxException {
        String path = new File(DoSave.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath();
        jsonFileName = jsonFileName.toLowerCase();

        String projectPath = path.substring(path.length() - 23);
        // Different absolute path for IDE and for JAR
        if (projectPath.equals("build\\classes\\java\\main")) { // IDE
            path = path.substring(0, path.length() - 23);
        } else { // JAR
            path = path.substring(0, path.length() - 38);
        }

        path += "build\\resources\\saves\\" + jsonFileName + ".json";

        Save.writeGameSave(path);
    }

    private DoSave(){} //hiding the implicit public constructor
}
