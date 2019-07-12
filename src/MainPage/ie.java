package MainPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ie {
	public void main (String [] arg) {
		System.setProperty("webdriver.ie.driver", "C:\\\\My programs\\\\Java projects\\\\IEDriverServer.exe");
		WebDriver driver=new InternetExplorerDriver();
	}

}
