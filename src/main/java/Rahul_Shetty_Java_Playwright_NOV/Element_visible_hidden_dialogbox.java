package Rahul_Shetty_Java_Playwright_NOV;

import java.awt.Dialog;
import java.nio.file.Paths;
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
import com.microsoft.playwright.Tracing.StopOptions;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class Element_visible_hidden_dialogbox {

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
		page = bcn.newPage();
		page.navigate("https://rahulshettyacademy.com/AutomationPractice/");
	}
	
	@Test
	public void test() throws InterruptedException {
		PlaywrightAssertions.assertThat(page.getByPlaceholder("Hide/Show Example")).isVisible();
		page.locator("#hide-textbox").click();
		PlaywrightAssertions.assertThat(page.getByPlaceholder("Hide/Show Example")).isHidden();
		
		//popoup
		page.onDialog(dialog -> dialog.accept());
		page.locator("#alertbtn").click();
		
	}
	
	
	@AfterMethod
	public void teardown() {
		page.close();
		bcn.close();
		br.close();
		ply.close();
	}
}
