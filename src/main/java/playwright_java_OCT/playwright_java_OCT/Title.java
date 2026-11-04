package playwright_java_OCT.playwright_java_OCT;

import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;
import com.microsoft.playwright.Playwright;

public class Title {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> arr=new ArrayList<String>();
		arr.add("--start-maximized");
		Playwright ply=Playwright.create();
		Browser br=ply.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arr));
		BrowserContext bcn=br.newContext(new NewContextOptions().setViewportSize(null));
		Page page=bcn.newPage();
		page.navigate("https://www.irctc.com/");
		System.out.println(page.title());
		
	}

}
