package rest;

import io.restassured.RestAssured;
import static org.hamcrest.core.StringContains.*;
//import static io.restassured.RestAssured.*;

import io.restassured.response.ValidatableResponse;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.PropertyReader;

public class FirstTestNGTest {

    private String basePath;

    @BeforeTest
    public void init() {

        //      RestAssured.baseURI = PropertyReader.FROM_CONFIG_FILE.getProperty("local_baseurl"); // Throws Error If Localhost Is Set. It's By Default localhost.
        //      RestAssured.port = Integer.valueOf(PropertyReader.FROM_CONFIG_FILE.getProperty("port"));

        RestAssured.baseURI = PropertyReader.FROM_CONFIG_FILE.getProperty("baseurl");
        RestAssured.basePath = PropertyReader.FROM_CONFIG_FILE.getProperty("path");
    }

    @Test
    public void testOne() {

//        ValidatableResponseLogSpec res = RestAssured.given().get("/").then().log();
//        System.out.println(res.all());
        ValidatableResponse all = RestAssured.given().get("/?page=2").then().log().all(true);
        all.assertThat().body(containsString("email"));
        all.header("X-Powered-By", "Express");

    }

}
