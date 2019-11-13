package junit;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.PropertyReader;

import static org.hamcrest.core.StringContains.containsString;

public class FirstJunitTest {

    private String basePath;

    @BeforeClass
    public static void init() {

        //      RestAssured.baseURI = PropertyReader.FROM_CONFIG_FILE.getProperty("local_baseurl"); // Throws Error If Localhost Is Set. It's By Default localhost.
        //      RestAssured.port = Integer.valueOf(PropertyReader.FROM_CONFIG_FILE.getProperty("port"));

        RestAssured.baseURI = PropertyReader.FROM_CONFIG_FILE.getProperty("baseurl");
        RestAssured.basePath = PropertyReader.FROM_CONFIG_FILE.getProperty("path");
    }

    @Test
    public void testOne() {

//        ValidatableResponseLogSpec res = RestAssured.given().get("/").then().log().all();
//        System.out.println(res.all());
        ValidatableResponse all = RestAssured.given().get("/?page=2").then().log().all(true);
        all.assertThat().body(containsString("email"));
        all.header("X-Powered-By", "Express");

    }

}
