package TestScript;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductListPage;

public class PlaceOrderTest {
	
	
	WebDriver driver;
	LoginPage loginPage;
	ProductListPage  listPage;  
	CartPage cartPage;

	
	public PlaceOrderTest() {
		TestBase.initDriver();
		driver= TestBase.getDriver();
		loginPage= new LoginPage(driver);
		listPage= new ProductListPage(driver);
		cartPage= new CartPage(driver);
	}
	@BeforeTest
	public void setup() {
		TestBase.openUrl("https://www.saucedemo.com/");
		loginPage.loginIntoApp("standard_user", "secret_sauce");
		
	}
	
	
	 @Test(priority=1)
	  public void validLogin() {
		 
		Assert.assertTrue(listPage.isOnproducts());
	  }
	
  @Test(priority=2)
  public void addItem() {
	listPage.addToCart();
	listPage.viewCert();
	Assert.assertTrue(cartPage.isItemAdded());
  }
  
  @Test(priority=3)
  public void checkoutTest() {
	   cartPage.checkoutItems();
  }
  
  
  
}
