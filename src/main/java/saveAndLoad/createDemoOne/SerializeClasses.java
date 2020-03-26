package saveAndLoad.createDemoOne;

import saveAndLoad.Save;

public class SerializeClasses {
    public static void serializeDemo() {
        String filePath = "C:/Users/bunio/IdeaProjects/Software-Design/src/main/resources/json/demo1.json";
        Save.writeGameSave(filePath);
    }
}
