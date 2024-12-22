package StepDfinations2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import POM.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.time.Duration;
import java.util.List;



public class Dashboard {

    WebDriver driver;
    WebDriverWait wait;
    Dashboard DashboardPage;
    // Locators for elements
    By buttons = By.tagName("button");
    By links = By.tagName("a");
    By inputFields = By.tagName("input");

    @Given("I am logged in and on the OrangeHRM Dashboard")
    public void loggedInOnDashboard() {
        Login.setUsername("Admin");
        Login.setPassword("admin123");
        Login.clickLogin();
        Assert.assertTrue(Login.isDashboardVisible());
    }

    @Then("I validate all buttons on the page")
    public void validateButtons() {
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        Assert.assertFalse(buttons.isEmpty(), "No buttons found on the page.");
        buttons.forEach(button -> Assert.assertTrue(button.isDisplayed()));
    }

    @Then("I validate all links on the page")
    public void validateLinks() {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        Assert.assertFalse(links.isEmpty(), "No links found on the page.");
        links.forEach(link -> Assert.assertTrue(link.isDisplayed()));
    }

    @Then("I validate all input fields on the page")
    public void validateInputFields() {
        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        Assert.assertFalse(inputs.isEmpty(), "No input fields found on the page.");
        inputs.forEach(input -> Assert.assertTrue(input.isDisplayed()));
    }

    @Then("I validate all attributes on the page")
    public void validateAttributes() {
        WebElement body = driver.findElement(By.tagName("body"));
        Assert.assertNotNull(body.getAttribute("class"), "No attributes found on the body tag.");
    
    }
}
