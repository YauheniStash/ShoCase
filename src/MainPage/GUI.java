package MainPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GUI {
	WebDriver driver;

	@BeforeMethod
	@Parameters({ "url", "browser" })
	public void URL(String url, String browser) {
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\My programs\\Java projects\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\My programs\\Java projects\\\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test(enabled = false)
	public void verifyAppIsLaunchedTC1() throws InterruptedException {
		Thread.sleep(3000);
		String mainPageTitle = driver.getTitle();
		Assert.assertEquals(mainPageTitle, "Sign Up - Shocase");
	}

	@Test(enabled = false)
	public void verifyLogoIsDisplayedTC2() {
		WebElement logo = driver.findElement(By.xpath("//img[@data-click='shocase']"));
		boolean b = logo.isDisplayed();
		Assert.assertTrue(b);
	}

	@Test(enabled = false)
	public void verifyLogoHasTooltipTC3() {
		WebElement logo = driver.findElement(By.xpath("//img[@data-click='shocase']"));
		String logoTooltip = logo.getAttribute("Title");
		Assert.assertEquals(logoTooltip, "Marketing's Professional Network");
	}

	@Test(enabled = false)
	public void VerifyShocaseLogoRedirectsToMainpage() throws InterruptedException {
		WebElement logo = driver.findElement(By.xpath("//img[@data-click='shocase']"));
		Thread.sleep(3000);
		logo.click();
		String mainPageTitle = driver.getTitle();
		Assert.assertEquals(mainPageTitle, "Sign Up - Shocase");
	}

	@Test(enabled = false)
	public void VerifyPeopleDropdownIsDisplayed() {
		WebElement peopleDropdown = driver.findElement(By.xpath("//span[text()='People']"));
		boolean b = peopleDropdown.isDisplayed();
		Assert.assertTrue(b);
	}

	@Test(enabled = false)
	public void VerifyWhenInDropdownSelectedPeopleInSearchTooltipSearchForPeopleByNameTitleSkillsOrOtherKeywords() {
		WebElement search = driver.findElement(By.xpath("//input[@type='search']"));
		String serchTitle = search.getAttribute("Title");
		Assert.assertEquals(serchTitle, "Search for people by Name, Title, Skills, or other keywords");
	}

	@Test(enabled = false)
	public void VerifyProjectCanBeSelectedInSearchDropdown() {
		WebElement peopleDropdown = driver.findElement(By.xpath("//span[text()='People']"));
		peopleDropdown.click();
		WebElement projectDropdown = driver.findElement(By.xpath("//li[contains(text(),'Project')]"));
		projectDropdown.click();
		boolean b = projectDropdown.isDisplayed();
		Assert.assertTrue(b);
	}
	
	@Test(enabled = false)
	public void TC8 () {
		WebElement peopleDropdown = driver.findElement(By.xpath("//span[text()='People']"));
		peopleDropdown.click();
		WebElement projectDropdown = driver.findElement(By.xpath("//li[contains(text(),'Project')]"));
		projectDropdown.click();
		WebElement search = driver.findElement(By.xpath("//input[@type='search']"));
		String serchTitle = search.getAttribute("Title");
		Assert.assertEquals(serchTitle, "Search for projects by type, brand, name, keyword...");
		
	}
 
	@Test(enabled = false)
	public void TC9() {
		WebElement peopleDropdown = driver.findElement(By.xpath("//span[text()='People']"));
		peopleDropdown.click();
		WebElement companyDropdown = driver.findElement(By.xpath("//li[contains(text(),'Company')]"));
		companyDropdown.click();
		boolean b = companyDropdown.isDisplayed();
		Assert.assertTrue(b);
	}
	
	@Test
	public void TC10() {
		WebElement peopleDropdown = driver.findElement(By.xpath("//span[text()='People']"));
		peopleDropdown.click();
		WebElement companyDropdown = driver.findElement(By.xpath("//li[contains(text(),'Company')]"));
		companyDropdown.click();
		WebElement search = driver.findElement(By.xpath("//input[@type='search']"));
		String serchTitle = search.getAttribute("Title");
		Assert.assertEquals(serchTitle, "Search for companies by brand, name, keyword...");
		
	}
	//div[contains(@class,'sis-header-search')]//ul[1]//li[1]//ul[1]//li[1]
	
		@AfterMethod
	public void quiteBrowser() {
		driver.quit();
	}
}
