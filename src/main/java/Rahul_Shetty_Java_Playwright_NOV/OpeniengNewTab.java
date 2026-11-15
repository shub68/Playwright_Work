package Rahul_Shetty_Java_Playwright_NOV;

import java.util.List;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.GetByRoleOptions;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class OpeniengNewTab {

	@Test
	public void tabs() {
		Playwright ply=Playwright.create();
		Browser browser=ply.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext bcn=browser.newContext();
		Page page=bcn.newPage();
		page.navigate("https://practice.expandtesting.com/windows");
		Page tab1=page.waitForPopup(()->{
			page.getByRole(AriaRole.LINK,new GetByRoleOptions().setName("Click Here")).click();
		});
		
		Page tab2=page.waitForPopup(()->{
			page.getByRole(AriaRole.LINK,new GetByRoleOptions().setName("Click Here")).click();

		});
		Page tab3=page.waitForPopup(()->{
		page.getByRole(AriaRole.LINK,new GetByRoleOptions().setName("Click Here")).click();
		});
		
		
		List<Page> Listtabs=bcn.pages();
		System.out.println(Listtabs.size());
		for (Page list : Listtabs) {
			System.out.println(list.title());
		}
	}
}
