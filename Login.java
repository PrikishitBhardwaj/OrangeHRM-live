package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Login {

    private static WebDriver driver;

    private static By usernameField = By.name("username");
    private static By passwordField = By.name("password");
    private static By loginButton = By.xpath("//button[@type='submit']");

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForUsernameField() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
    }

    public void waitForPasswordField() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
    }

    public void waitForLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
    }

    public static void setUsername(String username) {
        WebElement usernameInput = driver.findElement(usernameField);
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    public static void setPassword(String password) {
        WebElement passwordInput = driver.findElement(passwordField);
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public static void clickLogin() {
        driver.findElement(loginButton).click();
    }

	public static boolean isDashboardVisible() {
		// TODO Auto-generated method stub
		return false;
	}
}