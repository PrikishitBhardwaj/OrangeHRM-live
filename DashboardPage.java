package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DashboardPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators for elements
    private By buttons = By.tagName("button");
    private By links = By.tagName("a");
    private By inputFields = By.tagName("input");
    private By allElements = By.xpath("//*");

    // Constructor to initialize driver and wait
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Get all buttons
    public List<WebElement> getAllButtons() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(buttons));
        return driver.findElements(buttons);
    }

    // Get all links
    public List<WebElement> getAllLinks() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(links));
        return driver.findElements(links);
    }

    // Get all input fields
    public List<WebElement> getAllInputFields() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(inputFields));
        return driver.findElements(inputFields);
    }

    // Validate visibility of elements by locator
    private boolean validateElementsVisibility(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        for (WebElement element : elements) {
            if (!element.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    // Validate visibility of all buttons
    public boolean validateButtonsVisibility() {
        return validateElementsVisibility(buttons);
    }

    // Validate visibility of all links
    public boolean validateLinksVisibility() {
        return validateElementsVisibility(links);
    }

    // Validate visibility of all input fields
    public boolean validateInputFieldsVisibility() {
        return validateElementsVisibility(inputFields);
    }

    // Get attribute value of an element
    public String getElementAttribute(WebElement element, String attribute) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getAttribute(attribute);
    }

    // Validate specific attribute presence for all elements
    public boolean validateAttributes(String attribute) {
        List<WebElement> elements = driver.findElements(allElements);
        for (WebElement element : elements) {
            if (getElementAttribute(element, attribute) == null) {
                return false; // Return false if any element doesn't have the specified attribute
            }
        }
        return true;
    }

    // Click on a specific button by its index
    public void clickButtonByIndex(int index) {
        List<WebElement> buttonList = getAllButtons();
        if (index >= 0 && index < buttonList.size()) {
            buttonList.get(index).click();
        } else {
            throw new IndexOutOfBoundsException("Invalid button index: " + index);
        }
    }

    // Click on a specific link by its index
    public void clickLinkByIndex(int index) {
        List<WebElement> linkList = getAllLinks();
        if (index >= 0 && index < linkList.size()) {
            linkList.get(index).click();
        } else {
            throw new IndexOutOfBoundsException("Invalid link index: " + index);
        }
    }

    // Enter text into an input field by its index
    public void enterTextIntoInputField(int index, String text) {
        List<WebElement> inputList = getAllInputFields();
        if (index >= 0 && index < inputList.size()) {
            WebElement inputField = inputList.get(index);
            inputField.clear();
            inputField.sendKeys(text);
        } else {
            throw new IndexOutOfBoundsException("Invalid input field index: " + index);
        }
    }
}
