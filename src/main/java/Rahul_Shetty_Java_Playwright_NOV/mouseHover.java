package Rahul_Shetty_Java_Playwright_NOV;

import java.util.ArrayList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.Page.GetByRoleOptions;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;

public class mouseHover {
	
	Playwright ply;
	Browser br;
	BrowserContext bcn;
	Page page;

	@BeforeMethod
	public void setup() {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("--start-maximized");
		ply = Playwright.create();
		br = ply.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arr).setSlowMo(2000));
		bcn = br.newContext(new NewContextOptions().setViewportSize(null));
		page = bcn.newPage();
		page.navigate("https://rahulshettyacademy.com/AutomationPractice/");
	}
	
	@Test
	public void test() throws InterruptedException {
		
		page.locator("#mousehover").hover();
		page.getByRole(AriaRole.LINK, new GetByRoleOptions().setName("Top")).click();
		
	}
	
	
	@AfterMethod
	public void teardown() {
		page.close();
		bcn.close();
		br.close();
		ply.close();
	}

}
