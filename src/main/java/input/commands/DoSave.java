package input.commands;

import output.NonStoryPrinter;
import saveAndLoad.Save;

import java.io.File;
import java.net.URISyntaxException;

public class DoSave {
    public static void doSave() throws URISyntaxException {
        String path = new File(DoSave.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath();
        path = path.substring(0, path.length() - 32);
        path += "resources\\saves\\save0.json";

        Save.writeGameSave(path);
        NonStoryPrinter.print("Game has been successfully saved!");
    }

    public static void doAutoSave() throws URISyntaxException {
        String path = new File(DoSave.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath();
        path = path.substring(0, path.length() - 32);
        path += "resources\\saves\\autosave.json";

        Save.writeGameSave(path);
        NonStoryPrinter.print("Autosave completed!");
    }
}
