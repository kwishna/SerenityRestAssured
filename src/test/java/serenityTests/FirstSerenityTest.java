package serenityTests;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Manual;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Title;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import utils.PropertyReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static org.hamcrest.core.StringContains.containsString;

//import static io.restassured.RestAssured.*;

@RunWith(SerenityRunner.class)
public class FirstSerenityTest {

    @BeforeClass
    public static void init() {

        //      RestAssured.baseURI = PropertyReader.FROM_CONFIG_FILE.getProperty("local_baseurl"); // Throws Error If Localhost Is Set. It's By Default localhost.
        //      RestAssured.port = Integer.valueOf(PropertyReader.FROM_CONFIG_FILE.getProperty("port"));

        RestAssured.baseURI = PropertyReader.FROM_CONFIG_FILE.getProperty("baseurl");
        RestAssured.basePath = PropertyReader.FROM_CONFIG_FILE.getProperty("path");
    }

    @Test
    public void testOne() {

        int pageNo = 1;

        ValidatableResponse all = SerenityRest.given().get("/?page="+pageNo).then().log().all(true);
        all.assertThat().body(containsString("email"));
        all.header("X-Powered-By", "Express");

    }

    @Test
    public void testTwo() {

        int pageNo = 2;

        ValidatableResponse all = SerenityRest.given().get("/?page="+pageNo).then().log().all(true);
        all.assertThat().body(containsString("e-mail"));
        all.header("X-Powered-By", "Express");
        all.statusCode(201);

    }

    @Pending
    @Test
    public void testThree() {

        int pageNo = 2;

        ValidatableResponse all = SerenityRest.given().get("/?page="+pageNo).then().log().all(true);
        all.assertThat().body(containsString("e-mail"));
        all.header("X-Powered-By", "Express");
        all.statusCode(201);

    }

    @Ignore
    @Test
    public void testFour() {

        int pageNo = 2;

        ValidatableResponse all = SerenityRest.given().get("/?page="+pageNo).then().log().all(true);
        all.assertThat().body(containsString("e-mail"));
        all.header("X-Powered-By", "Express");
        all.statusCode(201);

    }

    @Manual
    @Test
    public void testFive() {

        int pageNo = 2;

        ValidatableResponse all = SerenityRest.given().get("/?page="+pageNo).then().log().all(true);
        all.assertThat().body(containsString("e-mail"));
        all.header("X-Powered-By", "Express");
        all.statusCode(201);

    }

//  @Test(expected = FileNotFoundException.class) // Won't Pass If Exception Is Not Thrown.
    @Test
    public void testSix() throws FileNotFoundException {

        FileInputStream s = new FileInputStream(new File(".\\test.txt"));
        // TODO
    }

    @Title("Test Seven")
    @Test
    public void testSeven() {

        int i = 1 / 0;

    }

}
