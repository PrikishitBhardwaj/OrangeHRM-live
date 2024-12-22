package StepDfinations2;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import POM.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class First extends BaseStep {

    static Login loginPage;

    @Given("I open the browser and navigate to {string}")
    public void i_open_the_browser_and_navigate_to(String url) throws InterruptedException {
        if (driver == null) {
            driver = new ChromeDriver();
            setDriver(driver); // Set the shared driver
            driver.manage().window().maximize();
            Thread.sleep(2000);
        }
        driver.get(url);
        loginPage = new Login(driver); // Initialize POM class
    }

    @When("I check the Page Title {string} for confirmation")
    public void i_check_the_page_title_for_confirmation(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match!");
    }

    @When("input Username {string} and Password {string}")
    public void input_username_and_password(String uname, String pass) {
        loginPage.waitForUsernameField();
        loginPage.waitForPasswordField();
        Login.setUsername(uname);
        Login.setPassword(pass);
    }

    @Then("click the login button")
    public void click_the_login_button() {
        loginPage.waitForLoginButton();
        Login.clickLogin();
    }

    @Then("close the browser")
    public void close_the_browser() {
        if (driver != null) {
            driver.quit();
            setDriver(null);
        }
    }
}
