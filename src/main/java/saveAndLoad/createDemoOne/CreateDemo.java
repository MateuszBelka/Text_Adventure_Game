package saveAndLoad.createDemoOne;


import java.net.URISyntaxException;

public class CreateDemo {
    /*
     * Only run once to create the json file with our demo.
     */
    public static void createDemo() throws URISyntaxException {
        InitClasses.initEverything();
        ConfigureClasses.configureEverything();
        SerializeClasses.serializeDemo();
    }
}
