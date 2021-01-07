package pageObjects;

import org.openqa.selenium.By;
import utility.Log;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import gherkin.lexer.Ca;

public class HeaderSection {
	 static Logger logger = Logger.getLogger(HeaderSection.class);
	WebDriver driver;
	//page object to be used in step definitions
	public HeaderSection(WebDriver driver) {
		this.driver=driver;
		
	}
	//Wait for pageload
	public void waitForPage() throws Throwable {
		try {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
		logger.debug("Explicit wait for page to load");
		}catch (Exception e) {
			e.printStackTrace();
			logger.debug("Exception in page explicit wait");
		}
	}
	
	//Changing search category
	public void changeCategory() throws Throwable {
		try {
		Select drpCategory=new Select(driver.findElement(By.id("searchDropdownBox")));
		drpCategory.selectByValue("search-alias=computers");
		logger.debug("search category chnaged:"+drpCategory);
		}catch (Exception e) {
			e.printStackTrace();
			logger.debug("error in handling method changeCategory");
		}
	}

	//searching product
	public void searchProduct() throws Throwable{
		try {
		WebElement searchproduct = driver.findElement(By.id("twotabsearchtextbox"));
		searchproduct.sendKeys("Macbook pro");
		WebElement search = driver.findElement(By.id("nav-search-submit-text"));
		search.click();
		logger.debug("Product searched from excel sheet");
		}catch (Exception e) {
			e.printStackTrace();
			logger.debug("Exception in searching product");
		}
	}
	//navigate to cart
	public void navCart() throws Throwable {
		//check if side view of add to cart is given
			try {
				Thread.sleep(1000);
				WebElement closePopup=driver.findElement(By.id("attach-popover-lgtbox"));
				closePopup.click();
				Thread.sleep(1000);
				WebElement goToCart=driver.findElement(By.id("nav-cart"));
				goToCart.click();
				/*if(driver.findElement(By.id("nav-cart-text-container")).isDisplayed()) {
					WebElement goToCart=driver.findElement(By.id("nav-cart-text-container"));
					goToCart.click();
				}else {
					WebElement sidepaneView=driver.findElement(By.id("attach-sidesheet-view-cart-button"));
					sidepaneView.click();
				}*/
			
			logger.debug("NAvigate to cart after product selection");
			}
			catch (Exception e) {
				e.printStackTrace();
				logger.debug("Exception in navigating to cart after product selection");
			}
		} 
	
	public void signout()throws Throwable {
		
		try {
		WebElement accountlist=driver.findElement(By.id("nav-link-accountList"));
		Actions hover=new Actions(driver);
		WebElement signout = driver.findElement(By.id("nav-item-signout"));
		hover.moveToElement(accountlist).moveToElement(signout).click().build().perform();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void categoryElectronics() throws Throwable {
		try {
		Select drpCategory=new Select(driver.findElement(By.id("searchDropdownBox")));
		drpCategory.selectByValue("search-alias=electronics");
		logger.debug("search category chnaged:"+drpCategory);
		}catch (Exception e) {
			e.printStackTrace();
			logger.debug("error in handling method changeCategory");
		}
	}
	
	public void searchDell() throws Throwable{
		try {
		WebElement searchproduct = driver.findElement(By.id("twotabsearchtextbox"));
		searchproduct.sendKeys("DELL Laptop");
		WebElement search = driver.findElement(By.id("nav-search-submit-text"));
		search.click();
		logger.debug("Product searched");
		}catch (Exception e) {
			e.printStackTrace();
			logger.debug("Exception in searching product");
		}
	}
	
}
