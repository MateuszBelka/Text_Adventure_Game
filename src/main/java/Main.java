import com.google.gson.Gson;
import ui.*;

import java.io.*;
import java.net.URL;

public class Main {
    public static void main (String[] args) {
        Initialisation init = new Initialisation();
        init.initializeEntireSystem();

        deserializeJSONdemo();

        /* DEV NOTE:
         * Keep in mind that nothing after this line of code will be executed.
         * If you'd like some code to run you will have to do that through
         * UI controllers.
         */
        UI.run();
    }

    /* Temporary method which is meant to test
     * the functionality of reading information from JSON file.
     */
    private static void deserializeJSONdemo() {
        InputStream in = null;
        try {
            URL url = new File ("src/main/resources/json/sample.json").toURI().toURL();
            in = url.openStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
        BufferedReader input = new BufferedReader(new InputStreamReader(in));

        Gson gson = new Gson();
        Sample json = gson.fromJson(input, Sample.class);

        System.out.println(json.getClass());
        System.out.println(json.toString());
        System.out.println("Check object variables from json");
        System.out.println("Name: " + json.name);
        System.out.println("Age: " + json.age);
    }
}