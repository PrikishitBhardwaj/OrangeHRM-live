package StepDfinations2;



import org.openqa.selenium.WebDriver;

public class BaseStep {
    protected static WebDriver driver; // Shared WebDriver instance

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver sharedDriver) {
        driver = sharedDriver;
    }
}

