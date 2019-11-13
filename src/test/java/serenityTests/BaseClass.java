package serenityTests;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import utils.PropertyReader;

public class BaseClass {

    @BeforeClass
    public static void init(){

        RestAssured.baseURI = PropertyReader.FROM_CONFIG_FILE.getProperty("baseurl");
        RestAssured.basePath = PropertyReader.FROM_CONFIG_FILE.getProperty("path");
    }
}
