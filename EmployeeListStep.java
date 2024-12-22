package StepDfinations2;


import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import POM.EmployeeListPage;

public class EmployeeListStep extends BaseStep {

    static EmployeeListPage employeeListPage;

    @When("I navigate to the Employee List page")
    public void i_navigate_to_the_employee_list_page() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
        employeeListPage = new EmployeeListPage(driver);
    }

    @When("I search for an employee {string}")
    public void i_search_for_an_employee(String employeeName) {
        employeeListPage.searchEmployee(employeeName);
    }

    @Then("I should see the employee in the results")
    public void i_should_see_the_employee_in_the_results() {
        Assert.assertTrue(employeeListPage.getEmployeeCount() > 0, "No employees found.");
    }
}

