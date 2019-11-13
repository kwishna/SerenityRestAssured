package serenityTests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import pojos.Employee;
import steps.SerenityCRUDStep;
import utils.RequestSpecs;

/**
 * @author Krishna
 * Create A csv File. Having 2 Columns With Name 'JOB' & 'NAME'. i.e Same As Our Runner Class Instance Vars.
 * We Need To Create Setters & Getters As Well In Order To Inject Data From CSV To Our Java Class.
 *
 * Note : While Running This Test. Issues Were Faced On JVM 11 & Above. Use JDK 8.
 *
 */
@Concurrent(threads = "2x") // 2 Threads Per CPU Core Is Assigned To Run The DataDriven Test. Default Value Is '2x' As Well. Only Used With Parametrized Test
@UseTestDataFrom("src\\test\\resources\\testdata\\data.csv") // We Can Create Sample Data For Testing Using 'Mockaroo.Com'
@RunWith(SerenityParameterizedRunner.class)
public class DataDrivenTest extends BaseClass{

    // These Getter Setters Are To Be Used To Inject Data From CSV To These Variables.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    private String name;
    private String job;

    @Steps
    SerenityCRUDStep step;

    @Title("Multiple Requests")
    @Test
    public void createMultiple(){

        Employee e = new Employee();
        e.setJob(getJob());
        e.setName(getName());

        step.createRequest(e).statusCode(201).spec(RequestSpecs.getResponseSpec());

    }
}
