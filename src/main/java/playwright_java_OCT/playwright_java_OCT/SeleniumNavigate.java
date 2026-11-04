package playwright_java_OCT.playwright_java_OCT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumNavigate {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.persistent.com");
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
