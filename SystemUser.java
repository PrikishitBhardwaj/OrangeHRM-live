package StepDfinations2;



import org.testng.Assert;

import POM.SystemUsersPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SystemUser extends BaseStep {

    static SystemUsersPage systemUsersPage;

    @When("I navigate to the System Users page")
    public void i_navigate_to_the_system_users_page() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
        systemUsersPage = new SystemUsersPage(driver);
    }

    @When("I search for a user {string}")
    public void i_search_for_a_user(String username) {
        systemUsersPage.searchUser(username);
    }

    @Then("I should see at least one user in the results")
    public void i_should_see_at_least_one_user_in_the_results() {
        Assert.assertTrue(systemUsersPage.getResultCount() > 0, "No users found.");
    }
}
