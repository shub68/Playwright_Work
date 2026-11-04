package Rahul_Shetty_Java_Playwright_NOV;

import java.util.ArrayList;

import org.testng.annotations.*;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.GetByRoleOptions;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;

public class IsEnabledIsVisible_Assertion {
	
	@Test
	public void test() {
		ArrayList<String> arr=new ArrayList<String>();
		arr.add("--start-maximized");
		Playwright ply=Playwright.create();
		Browser br=ply.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome").setArgs(arr));
		BrowserContext bcn=br.newContext(new NewContextOptions().setViewportSize(null));
		Page page=bcn.newPage();
		page.navigate("https://eventhub.rahulshettyacademy.com/");
		page.getByPlaceholder("you@email.com").fill("shubham@gmail.com");
		page.getByPlaceholder("••••••").fill("Shubham@6855");
		page.click("#login-btn");
		PlaywrightAssertions.assertThat(page.getByRole(AriaRole.LINK,new GetByRoleOptions().setName("Browse Events →"))).isVisible();
	}

}
