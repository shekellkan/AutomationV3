package runner;

import common.CommonMethods;
import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import framework.DriverManager;
import gherkin.formatter.model.Feature;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        glue={"steps"},
        features = {"src/test/resource/features"},
        monochrome = true)

public class RunCukesTest extends AbstractTestNGCucumberTests {

    private static Logger log = Logger.getLogger("RunCukesTest");

    @BeforeTest
    public void beforeExecution() {
        try {
            CommonMethods.logIn();
        }catch (Exception e) {
            log.error("Unable to login before execution");
        }
    }

    @AfterTest
    public void afterExecution() {
        try {
            CommonMethods.logOut();
        } catch (Exception e) {
            log.error("Unable to logout after execution", e);
        } finally {
            DriverManager.getInstance().quitDriver();
        }
    }

//    @Before
//    public void beforeScenario(Feature feature) {
//
//    }
//
//    @After
//    public void afterScenario(Feature feature){
//
//    }
}