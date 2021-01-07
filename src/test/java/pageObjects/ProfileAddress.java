package pageObjects;


import org.junit.Assert;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import utility.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.*;

public class ProfileAddress {
	 static Logger logger = Logger.getLogger(ProfileAddress.class);
	WebDriver driver;
	//page object to be used in step definitions
	public ProfileAddress(WebDriver driver) {
		this.driver=driver;
		
	}
	
	//navigate to add new address
		public void navNewAdress()throws Throwable{
			try {
			//Select account section
			WebElement account=driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"));
			account.click();
			//navigating to add new address
			WebElement adress=driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div/div[3]/div[1]/a/div"));
			adress.click();
			logger.debug("navigated to address section");
			}catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		public void addNewAdress() throws Throwable{
			try {
				Thread.sleep(1000);
			//adding new address
			WebElement addNewButton=driver.findElement(By.id("ya-myab-plus-address-icon"));
			addNewButton.click();
			
			
			//firstname
			WebElement firstName=driver.findElement(By.id("address-ui-widgets-enterAddressFullName"));
			firstName.sendKeys("abcTest");
			
			//phone number
			WebElement phoneNumber=driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber"));
			phoneNumber.sendKeys("8547691472");
			
			//pincode
			WebElement pinCode=driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode"));
			pinCode.sendKeys("673614");
			
			
			//address line1
			WebElement adress=driver.findElement(By.id("address-ui-widgets-enterAddressLine1"));
			adress.sendKeys("qwerty");
			
			//address line 2
			WebElement adresArea=driver.findElement(By.id("address-ui-widgets-enterAddressLine2"));
			adresArea.sendKeys("area1");
			
				Thread.sleep(1000);
				//region dropdown
			//Select drpState=new Select(driver.findElement(By.id("s-result-sort-selectaddress-ui-widgets-enterAddressStateOrRegion")));
			//drpState.selectByVisibleText("KERALA");
		
				//scroll the screen down
				//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL,Keys.END);
				//Thread.sleep(2000);
				
				JavascriptExecutor js=((JavascriptExecutor)driver);
				js.executeScript("window.scrollBy(0,500)");
				Thread.sleep(2000);			
				//address type as home or office
			//Select drpAddresType=new Select(driver.findElement(By.id("address-ui-widgets-addr-details-address-type-and-business-hours")));
			//drpAddresType.selectByVisibleText(" Home (7 am – 9 pm delivery) ");
			//submit button
			WebElement addAddresButton=driver.findElement(By.id("address-ui-widgets-form-submit-button"));
			addAddresButton.click();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		//verify address added
		public void verifyAdressAddition() throws InterruptedException {
			Thread.sleep(1000);
			//String message="Address saved";
			if(driver.getPageSource().contains("Address saved")) {
				System.out.println("Address saved succesfully");
			}else {
				System.out.println("Error Saving the new address");
			}
			
		}
		
}
