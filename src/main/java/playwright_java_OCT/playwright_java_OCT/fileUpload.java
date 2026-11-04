package playwright_java_OCT.playwright_java_OCT;

import java.nio.file.Path;
import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser.NewContextOptions;

public class fileUpload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> arr=new ArrayList<String>();
		arr.add("--start-maximized");
		Playwright ply=Playwright.create();
		Browser br=ply.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arr).setSlowMo(3000));
		BrowserContext bcn=br.newContext(new NewContextOptions().setViewportSize(null));
		Page page=bcn.newPage();
		page.navigate("https://aosdevsso.operativeone.com/openam/XUI/?realm=aosdev#login/&goto=https%3A%2F%2Finsights-dev.operativeone.com%3A443%2Fhome");
		page.getByPlaceholder("User Name").fill("supportops@aosonair.com");
		page.getByPlaceholder("Password").fill("Oper@t1ve");
		page.locator("//input[@value='Log in']").click();
		page.locator("//span[text()='Sources']").click();
		page.locator("//*[text()=' Add ']").click();
		page.locator("input[type='file'][accept='.csv']").setInputFiles(Path.of("C:\\Users\\shubham_lokare\\Downloads\\Deal Report_2_2026_09_03T15_47_54_11_12.csv"));
	}

}
