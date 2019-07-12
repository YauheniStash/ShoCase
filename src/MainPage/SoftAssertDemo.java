package MainPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertDemo {

	@Test
	public void demo() {
		SoftAssert sa = new SoftAssert();
		System.setProperty("webdriver.chrome.driver", "C:\\My programs\\Java projects\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://fluent.express");
		String title = driver.getTitle();
		String expectedTitle = "Get your English text checked instantly by a real person";
		sa.assertEquals(title, expectedTitle);
		driver.findElement(By.linkText("Sign up")).click();
		String signUpTitle=driver.getTitle();
		String signUpTitleEcpected="Sign up for fluent.expres";
		sa.assertEquals(signUpTitle, signUpTitleEcpected);
	    boolean b=	driver.findElement(By.xpath("//button[contains(text(),'Register')]")).isDisplayed();
		Assert.assertTrue(b);
		Assert.
		sa.assertAll();
		driver.quit();
	}

}
