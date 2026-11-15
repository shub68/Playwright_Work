package Rahul_Shetty_Java_Playwright_NOV;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.FrameLocator.GetByRoleOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.Browser.NewContextOptions;

public class SelectOptions {
	
	Playwright ply;
	Browser br;
	BrowserContext bcn;
	Page page;
	
	@Test
	public void test() {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("--start-maximized");
		ply = Playwright.create();
		br = ply.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arr).setSlowMo(2000));
		bcn = br.newContext(new NewContextOptions().setViewportSize(null));
		page = bcn.newPage();
		page.navigate("https://jqueryui.com/selectmenu/");
		page.waitForLoadState();
		FrameLocator frame=page.frameLocator("//iframe[@class='demo-frame']");
		frame.locator("//span[@class='ui-selectmenu-text' and text()='Medium']").click();
		frame.getByRole(AriaRole.OPTION, new GetByRoleOptions().setName("Slow").setExact(true)).click();
		
	}

}
