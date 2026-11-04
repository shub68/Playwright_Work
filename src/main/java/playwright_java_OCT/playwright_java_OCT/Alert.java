package playwright_java_OCT.playwright_java_OCT;

import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser.NewContextOptions;

public class Alert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> arr=new ArrayList<String>();
		arr.add("--start-maximized");
		Playwright ply=Playwright.create();
		Browser br=ply.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arr).setSlowMo(3000));
		BrowserContext bcn=br.newContext(new NewContextOptions().setViewportSize(null));
		Page page=bcn.newPage();
		page.navigate("https://demoqa.com/alerts");
		page.onDialog(dia ->{
			dia.accept();
			System.out.println(dia.type());
		});
		page.locator("//button[text()='Click me']").first().click();
		ply.close();
	}

}
