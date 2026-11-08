package Rahul_Shetty_Java_Playwright_NOV;

import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser.NewContextOptions;

public class Handeling_Child_Window {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> arr = new ArrayList<String>();
		arr.add("--start-maximized");
		Playwright ply = Playwright.create();
		Browser br = ply.chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arr).setSlowMo(2000));
		BrowserContext bcn = br.newContext(new NewContextOptions().setViewportSize(null));
		Page page = bcn.newPage();
		page.navigate("https://rahulshettyacademy.com/loginpagePractise/");
		Locator blinkinhtext = page.locator(".blinkingText");
		Page childWindow = bcn.waitForPage(() -> page.locator(".blinkingText").first().click());
		childWindow.waitForLoadState();
		String text = childWindow.locator("//p[text()='Please email us at ']").textContent();
		// Please email us at mentor@rahulshettyacademy.com with below template to
		// receive response
		String newtext = text.split("at")[1].split(" ")[0];
		System.out.println(newtext);
	}

}
