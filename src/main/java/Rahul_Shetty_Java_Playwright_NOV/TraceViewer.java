package Rahul_Shetty_Java_Playwright_NOV;

import java.nio.file.Paths;
import java.util.ArrayList;

import org.openqa.selenium.devtools.v129.tracing.Tracing;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing.StartOptions;
import com.microsoft.playwright.Tracing.StopOptions;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.Locator.FilterOptions;
import com.microsoft.playwright.Page.GetByRoleOptions;

public class TraceViewer {

	Playwright ply;
	Browser br;
	BrowserContext bcn;
	Page page;

	@BeforeMethod
	public void setup() {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("--start-maximized");
		ply = Playwright.create();
		br = ply.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arr).setSlowMo(1000));
		bcn = br.newContext(new NewContextOptions().setViewportSize(null));
		bcn.tracing().start(new StartOptions()
				.setScreenshots(true)
				.setSnapshots(true)
				.setSources(true));

		page = bcn.newPage();
		page.navigate("https://eventhub.rahulshettyacademy.com/login");

	}
	
	@Test
	public void test() {
		page.getByLabel("Email").fill("shubham@gmail.com");
 page.getByText("Yes, cancel it").click();
	}
	
	@AfterMethod
	public void teardown() {
		bcn.tracing().stop(new StopOptions().setPath(Paths.get("trace.zip")));
		page.close();
		bcn.close();
		br.close();
		ply.close();
	}

}
