package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountStep {
	LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	AccountsPage accountsPage;

	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credTable) {
		List<Map<String, String>> credList = credTable.asMaps();
		String userName = credList.get(0).get("username");
		String passwrd = credList.get(0).get("password");

		DriverFactory.getDriver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountsPage = loginPage.doLogin(userName, passwrd);

	}

	@Given("User is on Accounts page")
	public void user_is_on_accounts_page() {
		String title = accountsPage.getAccountsPageTitle();
		System.out.println("Title of the accounts page is: " + title);

	}

	@Then("user gets accounts section")
	public void user_gets_shopbyproductLink(DataTable sectionsTable) {

		List<String> expAccountSectionList = sectionsTable.asList();
		System.out.println("Expected accounts section List:" + expAccountSectionList);

		List<String> actualAccountSectionList = accountsPage.getAccountsSectionList();
		System.out.println("Actual accounts section List:" + actualAccountSectionList);

		Assert.assertTrue(expAccountSectionList.containsAll(actualAccountSectionList));

	}

	@Then("Accounts section count should be (\\d+)")
	public void accounts_section_count_should_be(Integer expectedSectionCount) {
		System.out.println("+++++++++++++++++The ACCOUNTS section count is:" + accountsPage.getAccountSectionCount()
				+ "++++++++++++++");
		Assert.assertTrue(accountsPage.getAccountSectionCount()== expectedSectionCount);

	}

}
