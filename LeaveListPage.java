package POM;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LeaveListPage {

    private WebDriver driver;

    private By fromDateField = By.xpath("//input[@placeholder='From']");
    private By toDateField = By.xpath("//input[@placeholder='To']");
    private By searchButton = By.xpath("//button[@type='submit']");
    private By resultRows = By.xpath("//div[@class='oxd-table-body']//div[@class='oxd-table-row']");

    public LeaveListPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterDateRange(String fromDate, String toDate) {
        WebElement fromDateInput = driver.findElement(fromDateField);
        fromDateInput.clear();
        fromDateInput.sendKeys(fromDate);

        WebElement toDateInput = driver.findElement(toDateField);
        toDateInput.clear();
        toDateInput.sendKeys(toDate);
    }

    public void clickSearch() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    public int getLeaveRequestCount() {
        List<WebElement> rows = driver.findElements(resultRows);
        return rows.size();
    }
}

