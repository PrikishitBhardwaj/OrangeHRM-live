package StepDfinations2;


import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import POM.LeaveListPage;

public class LeaveListSteps extends BaseStep{

    static LeaveListPage leaveListPage;

    @When("I navigate to the Leave List page")
    public void i_navigate_to_the_leave_list_page() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/leave/viewLeaveList");
        leaveListPage = new LeaveListPage(driver);
    }

    @When("I search leave requests from {string} to {string}")
    public void i_search_leave_requests_from_to(String fromDate, String toDate) {
        leaveListPage.enterDateRange(fromDate, toDate);
        leaveListPage.clickSearch();
    }

    @Then("I should see leave requests in the results")
    public void i_should_see_leave_requests_in_the_results() {
        Assert.assertTrue(leaveListPage.getLeaveRequestCount() > 0, "No leave requests found.");
    }
}

