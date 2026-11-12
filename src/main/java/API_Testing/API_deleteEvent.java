package API_Testing;

import org.testng.annotations.Test;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Request;
import com.microsoft.playwright.options.RequestOptions;

public class API_deleteEvent {
	
    @Test
	public void deleteEvent() {
		Playwright ply=Playwright.create();
		APIRequestContext api=ply.request().newContext(new APIRequest.NewContextOptions().setIgnoreHTTPSErrors(true));
		APIResponse deleteresponse=api.delete("https://eventhub.rahulshettyacademy.com/bookings/5346",RequestOptions.create().setHeader("Authorization", "Bearer "+"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOjE3OTUzLCJlbWFpbCI6InNodWJoYW1AZ21haWwuY29tIiwiaWF0IjoxNzk0MjQxMDI4LCJleHAiOjE3OTQ4NDU4Mjh9.JLhee-vY4xAnU3jrTV6q2SBly1Qg9XXx3foOoDN0zvQ"));
		boolean isdeleted=deleteresponse.ok();
		System.out.println("Is Event Deletd="+isdeleted);
	}
}
