package Rahul_Shetty_Java_Playwright_NOV;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.FillOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ClickOptions;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.assertions.LocatorAssertions;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class Assertion_Timeout_global_local {

	@Test
	public void test() {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("--start-maximized");
		Playwright ply = Playwright.create();
		Browser br = ply.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome").setArgs(arr).setSlowMo(1000));
		BrowserContext bcn = br.newContext(new NewContextOptions().setViewportSize(null));
		Page page = bcn.newPage();
		page.navigate("https://eventhub.rahulshettyacademy.com/");
		page.getByPlaceholder("you@email.com").fill("shubham@gmail.com");
		
		page.setDefaultTimeout(15000);
		
		page.getByPlaceholder("••••••").fill("Shubham@6855",new FillOptions().setTimeout(8000)); // This will wait for patricularly this element for 8 seconds
		
		page.click("#login-btn", new ClickOptions().setTimeout(6000));//this will wait for patricularly this element for 8 seconds
		
		page.navigate("https://eventhub.rahulshettyacademy.com/events");
		Locator loc=page.getByTestId("event-card");
		Locator loc1=loc.filter(new Locator.FilterOptions().setHasText("World Tech Summit"));
		
		PlaywrightAssertions.assertThat(loc1).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(3000));// this will only wait for particular assertion
		
		PlaywrightAssertions.setDefaultAssertionTimeout(7000); // Default assertion timeout will be applicable to all the assertion in the class
		

	}
}
