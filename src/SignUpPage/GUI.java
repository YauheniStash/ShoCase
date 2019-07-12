package SignUpPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GUI {
	WebDriver driver;
	@BeforeMethod
	@Parameters ({"browser"})
		
		public void URL(String browser) {
		if (browser.equals("chrome"))
				{System.setProperty("webdriver.chrome.driver", "C:\\My programs\\Java projects\\chromedriver.exe");
			driver=new ChromeDriver();}
		else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\My programs\\Java projects\\firefoxdriver.exe");
			driver=new FirefoxDriver();}			
		
	}
	@Test
	@Parameters({"url"})
	public void start(String url) {
		driver.get(url);
	}
}


