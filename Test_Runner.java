package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.ExtentReportManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
    features = "src/test/resources/Features",
    glue = "StepDefinitions",
    plugin = {"pretty", "html:target/cucumber-reports.html"},
    tags = "@All"
)
public class Test_Runner extends AbstractTestNGCucumberTests {

    private static ExtentReports extent;
    private static ExtentTest test;

    @BeforeClass
    public void setUp() {
        extent = ExtentReportManager.getExtentReports();
    }

    @AfterClass
    public void tearDown() {
        extent.flush();
    }
}
