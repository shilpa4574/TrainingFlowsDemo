package pageObjects;
import dataProvider.ExcelTestData;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import dataProvider.*;
public class LoginPages {
	 static Logger logger = Logger.getLogger(LoginPages.class);
	 ExcelTestData testdata=new ExcelTestData();
	 
	WebDriver driver;
	
	//creating an object of the class to be called in step definitions
	public LoginPages(WebDriver driver) {
		this.driver=driver;
	}
	//login method
	public void Loginmethod() throws Throwable{
		try {
		WebElement accountlist = driver.findElement(By.id("nav-link-accountList"));
		accountlist.click();
		logger.debug("My Account link element found");
		}catch (Exception e) {
			e.printStackTrace();
		}
		try {
			//ExcelTestData testData=new ExcelTestData();
		//enter username and continue
		WebElement username = driver.findElement(By.id("ap_email"));
		username.sendKeys("8547691472");
		
		WebElement buttoncontinue = driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div[1]/form/div/div/div/div[2]/span/span/input"));
		buttoncontinue.click();
		logger.debug("username submitted");
		}catch (Exception e) {
			e.printStackTrace();
		}
		try {
		//enter passsowrd and login
		WebElement password = driver.findElement(By.id("ap_password"));
		password.sendKeys("2020Paris");
		
		WebElement buttonlogin = driver.findElement(
				By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div[1]/div/div/form/div/div[2]/span/span/input"));
		buttonlogin.click();
		logger.debug("password submitted");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
