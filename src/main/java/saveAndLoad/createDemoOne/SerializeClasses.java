package saveAndLoad.createDemoOne;

import input.commands.DoSave;
import saveAndLoad.Save;

import java.io.File;
import java.net.URISyntaxException;

public class SerializeClasses {
    public static void serializeDemo() throws URISyntaxException {
        String path = new File(DoSave.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath();

        String projectPath = path.substring(path.length() - 23);
        // Different absolute path for IDE and for JAR
        if (projectPath.equals("build\\classes\\java\\main")) { // IDE
            path = path.substring(0, path.length() - 23);
        }

        path += "src\\main\\resources\\json\\demo1.json";

        Save.writeGameSave(path);
    }
}
