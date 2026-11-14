package Rahul_Shetty_Java_Playwright_NOV;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class VideoRecording {

	@Test
	public void video() {
        Path videpath=Paths.get("C:\\Automation_Practice\\playwright_java_OCT\\Videos");
		Playwright ply = Playwright.create();
		Browser browser = ply.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser
				.newContext(new NewContextOptions().setRecordVideoDir(videpath).setRecordVideoSize(100, 800).setIgnoreHTTPSErrors(true));
		Page page = context.newPage();
		page.navigate("https://www.facebook.com");
		context.close();
		browser.close();	
		System.out.println(page.video().path());
		page.video().delete();
	}

}
