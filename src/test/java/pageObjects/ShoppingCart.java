package pageObjects;

import org.openqa.selenium.By;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import utility.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCart {
	 static Logger logger = Logger.getLogger(ShoppingCart.class);
	WebDriver driver;
	public ShoppingCart(WebDriver driver) {
		this.driver=driver;
	}
	
	//To check if product is added in cart
	public void checkCartForProd() {
		/*Select qtyCart=new Select(driver.findElement(By.id("a-autoid-0-announce")));
		WebElement cartCount=qtyCart.getFirstSelectedOption();
		String itemsInCart=cartCount.getText();
		System.out.println(itemsInCart);
		*/
	}
	public void deleteCartItem() {
		try {
		WebElement deleteCartItem=driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[6]/div/div[2]/div[2]/div/form/div[2]/div[3]/div[4]/div/div[1]/div/div/div[2]/div[1]/span[2]/span/input"));
		deleteCartItem.click();
		logger.debug("Product deleted from cart");
		}catch (Exception e) {
			e.printStackTrace();
			logger.debug("Exception deleting the product from cart");
		}
	}
}
