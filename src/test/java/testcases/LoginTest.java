package testcases;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

public class LoginTest extends BaeClass{
	
	@Test
	public void test1() throws InterruptedException
	{	//call reusable function(parameterisation)
		
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("ABC@xyz.com","Test*12345678");
		WebElement error = driver.findElement(By.id("msg_box"));
		String Acterror  = error.getText();
		String Experror = "The email or password you have entered is invalid.";
		Assert.assertEquals(Acterror, Experror);
	}
	
	public void test4(Method method) throws FilloException, InterruptedException
	{
		Recordset recordset = connection.executeQuery("select * from data where TestName=" + method.getName() + "'");
		recordset.next();
			
		String UserName = recordset.getField("UserName");
		String Password = recordset.getField("Password");
		
		LoginPage login = new LoginPage(driver);
		login.LoginFunction(UserName, Password);
		
		
	}
	
}
