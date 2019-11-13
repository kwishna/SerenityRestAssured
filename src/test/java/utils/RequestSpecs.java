package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.lessThan;

public class RequestSpecs {

    public static RequestSpecification getReqSpec(){

        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.setAccept(ContentType.JSON);

        return reqBuilder.build();
    }

    public static ResponseSpecification getResponseSpec(){

        ResponseSpecBuilder resbuilder = new ResponseSpecBuilder();
        resbuilder.expectHeader("Content-Type", "application/json; charset=utf-8");
        resbuilder.expectHeader("X-Powered-By", "Express");
        resbuilder.expectResponseTime(lessThan(5L), TimeUnit.SECONDS);

        return resbuilder.build();
    }

}
