package Cucumber.Steps;

import cucumber.api.java.en.Given;

import net.thucydides.core.annotations.Steps;

import steps.SerenityCRUDStep;
import utils.RequestSpecs;

/**
 * Step Defination Class For Implementing Steps From .feature Files.
 */
public class MyStepdefs{

    @Steps
    private SerenityCRUDStep steps; // @Steps Annotation Request

    @Given("^user sends a GET request from \"([^\"]*)\" page no (\\d+)$")
    public void user_sends_a_GET_request_from_page_no(String arg1, int arg2) {

        steps.readRequest(arg1, arg2).spec(RequestSpecs.getResponseSpec());
    }
}
