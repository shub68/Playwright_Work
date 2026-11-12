package API_Testing;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;

public class API_CreateEvent {

	@Test
	public void createevent() {
		
		HashMap<Object, Object> data = new HashMap<Object, Object>();
		data.put("email", "shubham@gmail.com");
		data.put("password", "Shubham@6855");
		
		HashMap<Object, Object> data1 = new HashMap<Object, Object>();
		data1.put("title", "New Shubham Event");
		data1.put("description", "api");
		data1.put("category","Conference");
		data1.put("venue","Main road");
		data1.put("city","Banglore");
		data1.put("	eventDate","2026-07-16T05:41:00:000Z");
		data1.put("price","100");
		data1.put("totalSeats","500");
		
		
		Playwright ply = Playwright.create();
		APIRequestContext apirequest = ply.request().newContext( new APIRequest.NewContextOptions()
		        .setIgnoreHTTPSErrors(true));
		
		APIResponse loginResponse = apirequest.post("https://api.eventhub.rahulshettyacademy.com/api/auth/login",
				RequestOptions.create().setData(data));
		
		String token=JsonPath.read(loginResponse.text(),"$.token");
		System.out.println(token);
		
		APIResponse apiResponse = apirequest.post("https://eventhub.rahulshettyacademy.com/admin/events",
				RequestOptions.create().setHeader("Authorization", "Bearer"+token).setData(data1));
	}

}
