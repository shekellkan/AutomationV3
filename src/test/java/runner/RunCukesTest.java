package runner;

import common.CommonMethods;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import framework.DriverManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import ui.PageTransporter;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        glue={"steps"},
        features = {"src/test/resources/features"},
        monochrome = true)

public class RunCukesTest extends AbstractTestNGCucumberTests {

    private static Logger log = Logger.getLogger("RunCukesTest");

    @BeforeTest
    public void beforeExecution(){
        try{
            PageTransporter.getInstance().navigateToLoginPage();
        } catch(Exception e){
        }
    }

    @BeforeMethod
    public void beforeFeatureExecution(){
        try{
            CommonMethods.logIn("miguel.terceros@fundacion-jala.org", "morfeo3730");
        } catch(Exception e){
        }
    }

    @AfterTest
    public void afterExecution() {
        try {
            DriverManager.getInstance().quitDriver();
        } catch (Exception e) {
        }
    }

    @AfterMethod
    public void afterFeatureExecution(){
        try {
            CommonMethods.logOut();
        } catch (Exception e) {
        }
    }
}
