package Rahul_Shetty_Java_Playwright_NOV;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser.NewContextOptions;

public class screenshot {

	Playwright ply;
	Browser br;
	BrowserContext bcn;
	Page page;

	@BeforeMethod
	public void setup() {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("--start-maximized");
		ply = Playwright.create();
		br = ply.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arr));
		bcn = br.newContext(new NewContextOptions().setViewportSize(null));
		page = bcn.newPage();
		page.navigate("https://rahulshettyacademy.com/AutomationPractice/");
	}

	@Test
	public void test() {
		FrameLocator frametest = page.frameLocator("#courses-iframe");

		String text = frametest.locator(".new-navbar-highlighter").first().textContent();
		System.out.println("frame text is=" + text);
		page.screenshot(new Page.ScreenshotOptions().setFullPage(true).setPath(Paths.get("s1.png")));
		page.locator("//*[text()='iFrame Example']").scrollIntoViewIfNeeded();
		frametest.locator("(//a[@class='theme-btn'])[1]").scrollIntoViewIfNeeded();
		frametest.locator("(//a[@class='theme-btn'])[1]")
				.screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("ss.png")));
	}

	@AfterMethod
	public void teardown() {
		page.close();
		bcn.close();
		br.close();
		ply.close();
	}
}