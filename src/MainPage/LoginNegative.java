package MainPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginNegative extends testBase{
@Test (enabled=false)
public void invalidPassword () throws IOException {
	setUp();
	Properties prop=new Properties();
	FileInputStream file=new FileInputStream ("C:\\My programs\\Java projects\\ShoCase\\src\\MainPage\\data.properties");
	prop.load(file);
	driver.findElement(By.linkText("SIGN IN")).click();
	driver.findElement(By.name("email_address")).clear();
	driver.findElement(By.name("email_address")).sendKeys(prop.getProperty("validEmail"));
	driver.findElement(By.name("j_password")).clear();
	driver.findElement(By.name("j_password")).sendKeys(prop.getProperty("invalidPassword"));
	driver.findElement(By.id("sis-email-login-button")).click();
}
@Test (enabled=false)
public void invalidEmail () throws IOException {
	setUp();
	Properties prop=new Properties();
	FileInputStream file=new FileInputStream ("C:\\My programs\\Java projects\\ShoCase\\src\\MainPage\\data.properties");
	prop.load(file);
	driver.findElement(By.linkText("SIGN IN")).click();
	driver.findElement(By.name("email_address")).clear();
	driver.findElement(By.name("email_address")).sendKeys(prop.getProperty("invalidEmail"));
	driver.findElement(By.name("j_password")).clear();
	driver.findElement(By.name("j_password")).sendKeys(prop.getProperty("validPassword"));
	driver.findElement(By.id("sis-email-login-button")).click();
}

@Test (enabled=false)
public void emptyEmail () throws IOException, InterruptedException {
	setUp();
	Properties prop=new Properties();
	FileInputStream file=new FileInputStream ("C:\\My programs\\Java projects\\ShoCase\\src\\MainPage\\data.properties");
	prop.load(file);
	driver.findElement(By.linkText("SIGN IN")).click();
	driver.findElement(By.name("email_address")).clear();
	driver.findElement(By.name("email_address")).sendKeys(prop.getProperty("emptyEmail"));
	driver.findElement(By.name("j_password")).clear();
	Thread.sleep(3000);
	driver.findElement(By.name("j_password")).sendKeys(prop.getProperty("validPassword"));
	driver.findElement(By.id("sis-email-login-button")).click();
}
@Test 
public void emptyPassword () throws IOException, InterruptedException {
	setUp();
	Properties prop=new Properties();
	FileInputStream file=new FileInputStream ("C:\\My programs\\Java projects\\ShoCase\\src\\MainPage\\data.properties");
	prop.load(file);
	driver.findElement(By.linkText("SIGN IN")).click();
	WebElement RememberMe=driver.findElement(By.name("loginRemember"));
	RememberMe.click();
	driver.findElement(By.name("email_address")).clear();
	driver.findElement(By.name("email_address")).sendKeys(prop.getProperty("validEmail"));
	driver.findElement(By.name("j_password")).clear();
	WebElement SignInButton=driver.findElement(By.id("sis-email-login-button"));
	Thread.sleep(3000);
	SignInButton.click();
	driver.findElement(By.name("j_password")).clear();
	SignInButton.click();

}}