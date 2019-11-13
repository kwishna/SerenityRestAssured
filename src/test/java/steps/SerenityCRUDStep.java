package steps;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import utils.RequestSpecs;

/**
 * @author Krishna Kr. Singh
 * Step Page : It Has All The Re-usable Methods. Just Like Page In Page Object Model In Selenium.
 */
public class SerenityCRUDStep {

    @Step("Read Request | parameter : {0}, parameterValues : {1}") // @Step Used To Print In Report.
    public ValidatableResponse readRequest(String parameter, Object... parameterValues) { // Used In PUT Or PATCH

        return SerenityRest.rest().given()
//                .contentType(ContentType.JSON)
                .spec(RequestSpecs.getReqSpec())// RequestSpecification
                .when()
                .param(parameter, parameterValues)
                .log().all()
                .get()
                .then()
                .log()
                .all();
    }

    @Step("Create Request | jsonBody : {0}")
    public ValidatableResponse createRequest(String jsonBody) {

        return SerenityRest.given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(jsonBody)
                .post("/")
                .then();

    }

    @Step("Create Request | Object : {0}")
    public ValidatableResponse createRequest(Object obj) {

        return SerenityRest.given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(obj)
                .post("/")
                .then();

    }

    @Step("Delete Request | userId : {0}")
    public ValidatableResponse deleteRequest(String userId) {

        return SerenityRest.rest().given()

                .headers("Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON)
                .when()
                .log().all()
                .delete(userId)
                .then()
                .log().all();

    }

    @Step("Update Request | jsonBody : {0}, userId : {1}")
    public ValidatableResponse updateRequest(String jsonBody, String userId) {

        return SerenityRest.rest().given()

//                .urlEncodingEnabled(true)
//                .param("username", "user@site.com")
//                .param("password", "Pas54321")

                .headers("Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON)
                .when()
                .body(jsonBody)
                .log().all()
                .put(userId)
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();


    }

}
