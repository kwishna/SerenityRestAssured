package serenityTests;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import pojos.Employee;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SerenityCRUDTest extends BaseClass {

    static String id;

    @WithTag("CRUD:create") // (Feature : Group Type) /** mvn clean verify -Dtags="CRUD:create" serenity:aggregate  To Run Only Grouped Tests */
    @Title("Create Request")
    @Test
    public void test_1_create() {

        ValidatableResponse res =
                SerenityRest.given()
                        .contentType(ContentType.JSON)
                        .when().log().all()
                        .body("{\n" +
                                "    \"name\": \"morpheus\",\n" +
                                "    \"job\": \"leader\"\n" +
                                "}"
                        )

                        /*
                         * JSONObject requestParams = new JSONObject();
                         * 	requestParams.put("name", "morpheus"); // Cast
                         * 	requestParams.put("job", "not leader");
                         *
                         * 	requestParams.put("UserName", "63userf2d3d2011");
                         * 	requestParams.put("Password", "password1");
                         * 	requestParams.put("Email",  "ed26dff39@gmail.com");
                         */

                        .post("/")
                        .then();


        res
                .assertThat()
                .statusCode(201)
                .log().all();

        id = res.and().extract().body().jsonPath().get("id");
        id = res.extract().path("id");


        Object obj = res.extract().jsonPath().get("$");
        System.out.println("Create : Object Is : " + obj);

    }

    @WithTags( // Adding Multiple Groups
            {
                    @WithTag("CRUD:read"),
                    @WithTag("CRUD:smoke")
            }
    )
    @Title("Read Request")
    @Test
    public void test_2_read() {

        ValidatableResponse res =
                SerenityRest.rest().given()
                        .contentType(ContentType.JSON)
                        .when()
                        .param("page", 2)
                        .log().all()
                        .get()
                        .then()
                        .log()
                        .all();

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

        ValidatableResponse res = SerenityRest.rest().given()

//                .urlEncodingEnabled(true)
//                .param("username", "user@site.com")
//                .param("password", "Pas54321")

                .headers("Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON)
                .when()
                .body("{" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"not leader\"\n" +
                        "}"
                )
                .log().all()
                .put(userId)
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();

        Object obj = res.extract().jsonPath().get("$");
        System.out.println("Update : Object Is : " + obj);


    }

    @Title("Delete Request")
    @Test
    public void test_4_delete() {

        String userId = id;

        ValidatableResponse res = SerenityRest.rest().given()

//                .urlEncodingEnabled(true)
//                .param("username", "user@site.com")
//                .param("password", "Pas54321")

                .headers("Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON)
                .when()
                .log().all()
                .delete(userId)
                .then()
                .log().all();

    }

    @WithTag("CRUD:create")
    @Title("Create Request 2")
    @Test
    public void test_1_create2() {

        Employee e = new Employee();
        e.setJob("Worker");
        e.setName("Mr. X");

        ValidatableResponse res =
                SerenityRest.given()
                        .contentType(ContentType.JSON)
                        .when().log().all()
                        .body(e)
                        .post("/")
                        .then();


        res
                .assertThat()
                .statusCode(201)
                .log().all();
    }
}
