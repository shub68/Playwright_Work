package Rahul_Shetty_Java_Playwright_NOV;

import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class InvokingChrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> arr=new ArrayList<String>();
		arr.add("--start-maximized");
		Playwright ply=Playwright.create();
		Browser br=ply.chromium().launch(new LaunchOptions().setHeadless(false).setSlowMo(1000).setArgs(arr));
		BrowserContext bcn=br.newContext(new NewContextOptions().setViewportSize(null));
		Page page=bcn.newPage();
		page.navigate("https://eventhub.rahulshettyacademy.com/");
		PlaywrightAssertions.assertThat(page.locator("//*[text()='Email']")).containsText("Email");
		page.getByPlaceholder("you@email.com").fill("shubham@gmail.com");
		page.getByPlaceholder("••••••").fill("Shubham@6855");
		page.click("#login-btn");
		//PlaywrightAssertions.assertThat(page).hasTitle("Magic");
		page.close();
		bcn.close();
		br.close();
		ply.close();
	}

}
