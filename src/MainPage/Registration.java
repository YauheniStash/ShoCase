package MainPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;

public class Registration {
	WebDriver driver;
	@BeforeMethod
 
	public void setUp() {
	System.setProperty("webdriver.chrome.driver", "C:\\\\My programs\\\\Java projects\\\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.get("https://www.shocase.com/go/signup");
	driver.findElement(By.name("email_sign_up_mode_button")).click();
}
	
	@Test (dataProvider="getData")
	public void registration(String email, String firstname, String lastname) {
		
		driver.findElement(By.name("email_address")).clear();
		driver.findElement(By.name("email_address")).sendKeys(email);
		
		driver.findElement(By.name("firstName")).clear();
		driver.findElement(By.name("firstName")).sendKeys(firstname);
		
		driver.findElement(By.name("lastName")).clear();
		driver.findElement(By.name("lastName")).sendKeys(lastname);
		
		driver.findElement(By.id("sis-signup-email-button")).click();
	
	}
	
	@DataProvider
	public Object[][] getData() {
	Object data[][]=new Object[2][3];
	data[0][0]="kuku@gmail.com";
	data[0][1]="Vital";
	data[0][2]="Pupkin";
	
	data[1][0]="vasgxvg@gmail.com";
	data[1][1]="Max";
	data[1][2]="";
	return data;
	}
	
}
	
	
/*@AfterMethod
public void tearDown() {
	driver.quit();*/



