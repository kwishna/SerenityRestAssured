package utils;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertyReader {

    private static Reader r;
    public static Properties FROM_CONFIG_FILE;
    public static Properties XPATH;

    static{
        try {
//          F:\ABD\Eclipse\Eclipse_Works\SerenityRestAssured\src\test\resources\properties\config.properties

            // Using Java 8 :-
            r = Files.newBufferedReader(Paths.get(System.getProperty("user.dir")+"/src/test/resources/properties/"+"config.properties"));
            FROM_CONFIG_FILE = new Properties();
            FROM_CONFIG_FILE.load(r);

//          r = Files.newBufferedReader(Paths.get(System.getProperty("user.dir")+"/src/test/resources/properties/"+"xpath.properties"));

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
