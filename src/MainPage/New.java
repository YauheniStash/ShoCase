package MainPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class New extends testBase {
/*	@Test (priority=1)
	public void next0() throws IOException {
		registration();
	}
	
	
	@Test (priority=2)
	public void next1() throws IOException {
		registration();
		driver.findElement(By.linkText("SIGN IN")).click();
	}*/
	
	@Test (priority=3)
	public void next2() throws IOException, InterruptedException {
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream ("C:\\My programs\\Java projects\\ShoCase\\src\\MainPage\\data.properties");
        prop.load(file);
		registration();
		driver.findElement(By.linkText("SIGN IN")).click();
		driver.findElement(By.name("email_address")).sendKeys(prop.getProperty("email"));
		driver.findElement(By.name("j_password")).clear();
		driver.findElement(By.name("j_password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("sis-email-login-button")).click();
		WebDriverWait wait=new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Incorrect username or password.']")));
	boolean b =	driver.findElement(By.xpath("//span[text()='Incorrect username or password.']")).isDisplayed();
	
		Assert.assertTrue(b);
	}
	
	
}