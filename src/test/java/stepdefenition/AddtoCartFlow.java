package stepdefenition;

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

public class AddtoCartFlow {
	WebDriver driver;
	//LoginPages login;
	//HeaderSection pageHeader;
	//ProductDescriptionPages productPages;
	//ShoppingCart cart;
	ConfigFileReader configFileReader;
	WebDriverManager webDriverManager;

	@Given("^User login to amazon account$")
	public void user_login_to_amazon_account() throws Throwable {
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

	@When("^A product is searched$")
	public void a_product_is_searched()throws Throwable {
		HeaderSection pageHeader = new HeaderSection(driver);
		ProductDescriptionPages productPages = new ProductDescriptionPages(driver);

		// explicit wait until visibility of search bar
		pageHeader.waitForPage();
		// change search category
		pageHeader.changeCategory();
		// search for product
		pageHeader.searchProduct();
		// Sorting by price
		productPages.sortList();

	}

	@Then("^product is added to cart$")
	public void product_is_added_to_cart() throws Throwable {
		ProductDescriptionPages productPages= new ProductDescriptionPages(driver);
		// select product of highest price
		productPages.selectProd();
		// product opens in new tab switching control to new tab
		productPages.changeControl();
		// add product to cart
		productPages.addToCart();
	}

	@Then("^verify the cart has the product$")
	public void verify_the_cart_has_the_product() throws Throwable {
		HeaderSection pageHeader = new HeaderSection(driver);
		ShoppingCart cart = new ShoppingCart(driver);
		// navigate to shopping cart

		pageHeader.navCart();

		// check if item present in cart
		cart.checkCartForProd();

	}

	@Then("^delete the product and verify the entry is removed$")
	public void delete_the_product_and_verify_the_entry_is_removed() throws Throwable {
		ShoppingCart cart = new ShoppingCart(driver);
		// delete the product
		cart.deleteCartItem();

	}

	@Then("^logout the account$")
	public void logout_the_account() throws Throwable {
		HeaderSection pageHeader = new HeaderSection(driver);
		// Verify if the shopping cart is empty
		// WebElement
		// cartentry=driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[6]/div/div[2]/div[2]/div/div[1]/div/h1"));

		// signout
		pageHeader.signout();
		//driver.quit();
	}

}
