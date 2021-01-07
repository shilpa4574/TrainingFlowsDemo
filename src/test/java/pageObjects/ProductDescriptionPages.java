package pageObjects;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProductDescriptionPages {
	 static Logger logger = Logger.getLogger(ProductDescriptionPages.class);
	 
	WebDriver driver;
	public ProductDescriptionPages(WebDriver driver) {
		this.driver=driver;
	}
	public void sortList()throws Throwable {
		try {
		Select drpSort=new Select(driver.findElement(By.id("s-result-sort-select")));
		drpSort.selectByVisibleText("Price: High to Low");
		logger.debug("Product sort according to value");
		}catch (Exception e) {
			e.printStackTrace();
			logger.debug("Error sorting the product");
		}
	}
	public void selectProd()throws Throwable {
		try {
		WebElement product = driver.findElement(
				By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/span[3]/div[2]/div[2]/div/span/div/div/div[2]/div[2]/div/div[1]"));
		product.click();
		logger.debug("First product after the sort is selected");
		}catch (Exception e) {
			e.printStackTrace();
			logger.debug("Error selecting the product after sort");
		}
		
	}
	//changing control to new page opened
	public void changeControl() throws Throwable{
		try {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	//adding product to cart
	public void addToCart()throws Throwable {
try {
		WebElement addtocart = driver.findElement(By.id("add-to-cart-button"));
		addtocart.click();
		logger.debug("Product added to cart");
}catch (Exception e) {
	e.printStackTrace();
	logger.debug("Error adding the product to cart");
}
	}
	public void filterSearch()throws Throwable {
		WebElement starRating=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div/div[3]/span/div[1]/span/div/div/div[3]/ul/li[1]/span/a/section/i"));
		starRating.click();
		
	}
	
	public void filterOutput() {
		
		String totalResultCount=driver.findElement(By.cssSelector("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[1]")).getText();
		System.out.println("Total search results="+totalResultCount);
	}
	
	public void changeSearchCat() throws Throwable {
		try {
		Select drpCategory=new Select(driver.findElement(By.id("searchDropdownBox")));
		drpCategory.selectByValue("search-alias=computers");
		logger.debug("search category chnaged:"+drpCategory);
		}catch (Exception e) {
			e.printStackTrace();
			logger.debug("error in handling method changeCategory");
		}
	}
}
