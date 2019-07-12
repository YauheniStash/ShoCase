package MainPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Login extends testBase {

	@Test (enabled=false)
	public void loginNegative() throws IOException, InterruptedException {

		login();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.titleContains("Upload a Photo - Shocase"));
		String title = driver.getTitle();
		Assert.assertEquals("Upload a Photo - Shocase", title);
	}

	@Test (enabled=false)
	public void popUpText1() throws IOException {
		login();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//h1[text()='Welcome back to Shocase']")));
		boolean b = driver.findElement(By.xpath("//h1[text()='Welcome back to Shocase']")).isDisplayed();
		Assert.assertTrue(b);
	}

	@Test (enabled=false)
	public void popUpText2() throws IOException {
		login();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(text(),'We need a few more')]")));
		String text = driver.findElement(By.xpath("//div[contains(text(),'We need a few more')]")).getText();
		Assert.assertEquals(text,
				"We need a few more pieces of information to help you get connected, find work or talent and stay up-to-date.");
	}

	@Test (enabled=false)
	public void skipPhoto() throws IOException {
		login();

		driver.findElement(By.xpath("//button[text()='OK']")).click();

		WebElement link = driver.findElement(By.id("sis-onboard-photo-form-skip-link"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", link);
		WebDriverWait wait=new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.titleIs("Add Your Location - Shocase"));
		String title = driver.getTitle();
		Assert.assertEquals(title, "Add Your Location - Shocase");
	}
	@Test (enabled=false)
	public void skipLocation() throws IOException  {
		skipPhoto();
		WebElement link=driver.findElement(By.name("photo_skip_button"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", link);
		WebDriverWait wait=new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.titleIs("Grow Your Network Further - Shocase"));
		String title = driver.getTitle();		
		Assert.assertEquals(title, "Grow Your Network Further - Shocase");
	}
	
	@Test 

	public void skipConnections() throws IOException, InterruptedException  {
		
		skipLocation();
		WebElement link=driver.findElement(By.name("network_further_skip_button"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", link);
		WebDriverWait wait=new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.titleIs("News Feed - Shocase"));
		String title1=driver.getTitle();
		Assert.assertEquals(title1, "News Feed - Shocase");
	}
}
