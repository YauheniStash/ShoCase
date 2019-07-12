package MainPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ReporterConfig.Property;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class testBase {
	WebDriver driver;
	
	@BeforeMethod 
	
	public void setUp() throws IOException  {
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream ("C:\\My programs\\Java projects\\ShoCase\\src\\MainPage\\data.properties");
        prop.load(file);
        if (prop.getProperty("browser").equals("chrome")) {
	System.setProperty("webdriver.chrome.driver", "C:\\\\My programs\\\\Java projects\\\\chromedriver.exe");
	driver=new ChromeDriver();}
        else if (prop.getProperty("browser").equals("firefox")) {
        	System.setProperty("webdriver.gecko.driver", "C:\\\\My programs\\\\Java projects\\\\geckodriver.exe");
        	driver=new FirefoxDriver();}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.get(prop.getProperty("URL"));
	
}
	@Test
	(enabled=false)
	public void registration() throws IOException {
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream ("C:\\My programs\\Java projects\\ShoCase\\src\\MainPage\\data.properties");
        prop.load(file);
        driver.findElement(By.name("email_sign_up_mode_button")).click();
		driver.findElement(By.name("email_address")).clear();
		driver.findElement(By.name("email_address")).sendKeys(prop.getProperty("email"));
		
		driver.findElement(By.name("firstName")).clear();
		driver.findElement(By.name("firstName")).sendKeys(prop.getProperty("firstname"));
		
		driver.findElement(By.name("lastName")).clear();
		driver.findElement(By.name("lastName")).sendKeys(prop.getProperty("lastname"));
		
		driver.findElement(By.id("sis-signup-email-button")).click();
	
	}
	@Test 
	public void login() throws IOException {
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream ("C:\\My programs\\Java projects\\ShoCase\\src\\MainPage\\data.properties");
        prop.load(file);
		driver.findElement(By.linkText("SIGN IN")).click();
		driver.findElement(By.name("email_address")).clear();
		driver.findElement(By.name("email_address")).sendKeys(prop.getProperty("validEmail"));
		driver.findElement(By.name("j_password")).clear();
		driver.findElement(By.name("j_password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.id("sis-email-login-button")).click();
		return;
	}
	
}
