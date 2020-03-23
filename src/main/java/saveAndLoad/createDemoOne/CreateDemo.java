package saveAndLoad.createDemoOne;


public class CreateDemo {
    /*
     * Only run once to create the json file with our demo.
     */
    public static void createDemo() {
        InitClasses.initEverything();
        ConfigureClasses.configureEverything();
        SerializeClasses.serializeDemo();
    }
}
