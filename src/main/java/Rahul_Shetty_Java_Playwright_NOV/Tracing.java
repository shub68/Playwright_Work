package Rahul_Shetty_Java_Playwright_NOV;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.Locator.FilterOptions;
import com.microsoft.playwright.Page.GetByRoleOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing.StartOptions;
import com.microsoft.playwright.Tracing.StopOptions;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;

public class Tracing {

	@Test
	public void tracing() {
		Playwright ply = Playwright.create();
		Browser browser = ply.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext(new NewContextOptions());
		Page page=context.newPage();
		page.navigate("https://www.facebook.com");
		context.tracing().start(new StartOptions().setScreenshots(true).setSnapshots(true).setSources(true));
		page.navigate("https://www.facebook.com");
		page.navigate("https://eventhub.rahulshettyacademy.com/login");
		page.getByLabel("Email").fill("shubham@gmail.com");
		page.getByLabel("Password").fill("Shubham@6855");
		page.getByRole(AriaRole.BUTTON, new GetByRoleOptions().setName("Sign In")).click();
		Locator BrowserEvent = page.getByText("Browse Events →");
		PlaywrightAssertions.assertThat(BrowserEvent).isVisible();
		BrowserEvent.click();
		Locator allEvent=page.locator("#event-card").filter(new Locator.FilterOptions().setHasText("Dilli Diwali Mela"));
		allEvent.getByTestId("book-now-btn").click();
		page.getByPlaceholder("Your full name").fill("SBLq Seltos");
		page.getByPlaceholder("you@email.com").fill("shubh1@gmail.com");
		page.getByPlaceholder("+91 98765 43210").fill("1234567897");
		page.getByRole(AriaRole.BUTTON,new GetByRoleOptions().setName("Confirm Booking")).click();
		page.getByText("Your tickets are reserved.").isVisible();
		String eventPagebookingId=page.locator("//span[text()='Booking Ref']/..//span//span").innerText();
		page.getByRole(AriaRole.BUTTON,new GetByRoleOptions().setName("View My Bookings")).click();
		PlaywrightAssertions.assertThat(page.locator("//span[text()='"+eventPagebookingId+"']")).isVisible();
		Locator cancelBooking = page.getByTestId("booking-card").filter(new FilterOptions().setHasText(eventPagebookingId));
		cancelBooking.getByText("Cancel Booking").click();
		page.getByText("Yes, cancel it").click();
		context.tracing().stop(new StopOptions().setPath(Paths.get("tracingfile.zip")));
	}

}
