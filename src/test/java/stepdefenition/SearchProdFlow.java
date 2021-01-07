package stepdefenition;

import org.openqa.selenium.WebDriver;
import dataProvider.ConfigFileReader;
import managers.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProvider.ConfigFileReader;
import pageObjects.LoginPages;
import pageObjects.HeaderSection;
import pageObjects.ProductDescriptionPages;
import pageObjects.ShoppingCart;
import managers.WebDriverManager;

public class SearchProdFlow {

	WebDriver driver;
	ConfigFileReader configFileReader;
	WebDriverManager webDriverManager;
	
	@Given("^A user is logged in amazon accoount$")
	public void a_user_is_logged_in_amazon_accoount() throws Throwable {
		// initialising chrome driver and loading the amazon url
				configFileReader= new ConfigFileReader();
				webDriverManager = new WebDriverManager();
				 driver = webDriverManager.getDriver();
				 
				// implicit wait
				driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
				driver.get(configFileReader.getApplicationUrl());
				driver.manage().window().maximize();

				LoginPages login = new LoginPages(driver);
				// method login to account
				login.Loginmethod();
	}

	@When("^he searches for a product$")
	public void he_searches_for_a_product() throws Throwable {
		HeaderSection pageHeader = new HeaderSection(driver);
		ProductDescriptionPages productPages = new ProductDescriptionPages(driver);
Thread.sleep(1000);
		// explicit wait until visibility of search bar
		pageHeader.waitForPage();
		// change search category
		pageHeader.categoryElectronics();
		// search for product
		Thread.sleep(1000);
		pageHeader.searchDell();
	}

	@Then("^the search result is verified$")
	public void the_search_result_is_verified() throws Throwable {
		ProductDescriptionPages productPages = new ProductDescriptionPages(driver);
		Thread.sleep(1000);
		productPages.filterSearch();
		//searc results output
		Thread.sleep(1000);
		//productPages.filterOutput();
	}

	@Then("^account is signedout$")
	public void account_is_signedout() throws Throwable {
		HeaderSection pageHeader = new HeaderSection(driver);
		Thread.sleep(1000);
		pageHeader.signout();
		Thread.sleep(2000);
				driver.quit();
	}
	
}
