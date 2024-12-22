package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SystemUsersPage {

    private WebDriver driver;

    private By searchField = By.xpath("//input[@placeholder='Type for hints...']");
    private By searchButton = By.xpath("//button[@type='submit']");
    private By resultRows = By.xpath("//div[@class='oxd-table-body']//div[@class='oxd-table-row']");

    public SystemUsersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchUser(String username) {
        WebElement searchInput = driver.findElement(searchField);
        searchInput.clear();
        searchInput.sendKeys(username);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    public int getResultCount() {
        List<WebElement> rows = driver.findElements(resultRows);
        return rows.size();
    }
}

