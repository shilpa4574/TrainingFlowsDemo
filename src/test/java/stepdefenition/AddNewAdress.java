package stepdefenition;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProvider.ConfigFileReader;
import pageObjects.LoginPages;
import pageObjects.HeaderSection;
import managers.WebDriverManager;
import pageObjects.ProfileAddress;

public class AddNewAdress {
	WebDriver driver;
	// LoginPages login;
	// HeaderSection pageHeader;
	// ProductDescriptionPages productPages;
	// ShoppingCart cart;
	ConfigFileReader configFileReader;
	WebDriverManager webDriverManager;

	@Given("^User is logged in amazon account$")
	public void user_is_logged_in_amazon_account() throws Throwable {
		// initialising chrome driver and loading the amazon url
		configFileReader = new ConfigFileReader();
		webDriverManager = new WebDriverManager();
		driver = webDriverManager.getDriver();

		// implicit wait
		// driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(),
		// TimeUnit.SECONDS);
		driver.get(configFileReader.getApplicationUrl());
		driver.manage().window().maximize();

		LoginPages login = new LoginPages(driver);
		// method login to account
		login.Loginmethod();
	}

	@When("^Your address section in my account is selected$")
	public void your_address_section_in_my_account_is_selected() throws Throwable {
		ProfileAddress profileAddr = new ProfileAddress(driver);
		profileAddr.navNewAdress();

	}

	@Then("^add new address and verify$")
	public void add_new_address_and_verify() throws Throwable {
		ProfileAddress profileAddr = new ProfileAddress(driver);
		// method to add new address
		profileAddr.addNewAdress();
		// method to verify if address addition successful
		profileAddr.verifyAdressAddition();
	}

	@Then("^Signout the account$")
	public void signout_the_account() throws Throwable {
		HeaderSection pageHeader = new HeaderSection(driver);
		Thread.sleep(1000);
		//method to signout
		pageHeader.signout();
		Thread.sleep(1000);
		driver.quit();
	}

}
