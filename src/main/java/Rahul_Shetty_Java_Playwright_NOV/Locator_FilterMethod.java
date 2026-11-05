package Rahul_Shetty_Java_Playwright_NOV;

import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.FilterOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.Browser.NewContextOptions;

public class Locator_FilterMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> arr=new ArrayList<String>();
		arr.add("--start-maximized");
		Playwright ply=Playwright.create();
		Browser br=ply.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome").setArgs(arr).setSlowMo(1000));
		BrowserContext bcn=br.newContext(new NewContextOptions().setViewportSize(null));
		Page page=bcn.newPage();
		page.navigate("https://eventhub.rahulshettyacademy.com/");
		page.getByPlaceholder("you@email.com").fill("shubham@gmail.com");
		page.getByPlaceholder("••••••").fill("Shubham@6855");
		page.click("#login-btn");
		page.navigate("https://eventhub.rahulshettyacademy.com/events");
		Locator loc=page.getByTestId("event-card");
		System.out.println(loc.count());//to get count of locators
		Locator loc1=loc.filter(new Locator.FilterOptions().setHasText("World Tech Summit"));
		PlaywrightAssertions.assertThat(loc1).isVisible();
		PlaywrightAssertions.assertThat(loc.filter(new Locator.FilterOptions().setHasText("World Tech Summit"))).isVisible();
		page.close();
		bcn.close();
		br.close();
		ply.close();
	}

}
