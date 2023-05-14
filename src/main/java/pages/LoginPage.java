package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	
	//================================Objects===================//
	@FindBy(linkText="Log in")
	WebElement loginlink;
	@FindBy(name="user_login")
	WebElement Username1;
	@FindBy(id="password")
	WebElement password;
	@FindBy(className="rememberMe")
	WebElement rem;
	@FindBy(name="btn_login")
	WebElement Loginbtn;
	
	//================================methods========================//
	
	//constructor to base class driver
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		//init for findby methos
		PageFactory.initElements(driver, this);
	}
	
	public void LoginFunction(String Usernameval,String Passwordval) throws InterruptedException
	{
		//WebElement loginlink = driver.findElement(By.linkText("Log in"));
		loginlink.click();
		Thread.sleep(5000);
		Username1.sendKeys(Usernameval);
		password.sendKeys(Passwordval);
		rem.click();
		Loginbtn.click();
		//Thread.sleep(3000);
	}


}
