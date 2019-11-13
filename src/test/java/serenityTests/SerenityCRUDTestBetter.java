package serenityTests;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import pojos.Employee;
import steps.SerenityCRUDStep;
import utils.RequestSpecs;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SerenityCRUDTestBetter extends BaseClass {

    static String id;

    @Steps
    SerenityCRUDStep crud;

    @Title("Create Request")
    @Test
    public void test_1_create() {

        String jsonBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

        ValidatableResponse res = crud.createRequest(jsonBody);

        res
                .assertThat()
                .statusCode(201)
                .spec(RequestSpecs.getResponseSpec())
                .log().all();

        id = res.and().extract().body().jsonPath().get("id");
        id = res.extract().path("id");


        Object obj = res.extract().jsonPath().get("$");
        System.out.println("Create : Object Is : " + obj);

    }


    @Title("Read Request")
    @Test
    public void test_2_read() {

        ValidatableResponse res = crud.readRequest("page", 2);

//        String body = res.extract()
//                .body() // .as(Some.class) -> De-Serialization
//                .asString();

        Object obj = res.extract().jsonPath().getString("data.id"); // Gives List Of All ids
               obj = res.extract().jsonPath().getString("data[0].id"); // Gives Only First id
        System.out.println("Read : Object Is : " + obj);

    }

    @Title("Update Request")
    @Test
    public void test_3_update() {

        String userId = id;

        String jsonBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

        ValidatableResponse res = crud.updateRequest(jsonBody, id);
        Object obj = res.extract().jsonPath().get("$");
        System.out.println("Update : Object Is : " + obj);


    }

    @Title("Delete Request")
    @Test
    public void test_4_delete() {

        String userId = id;

        ValidatableResponse res = crud.deleteRequest(id);

    }

    @Title("Create Request 2")
    @Test
    public void test_1_create2() {

        Employee e = new Employee();
        e.setJob("Worker");
        e.setName("Mr. X");

        ValidatableResponse res = crud.createRequest(e);

        res
                .assertThat()
                .statusCode(201)
                .log().all();
    }
}
