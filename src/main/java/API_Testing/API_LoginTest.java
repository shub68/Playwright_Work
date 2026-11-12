package API_Testing;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;

public class API_LoginTest {

	@Test
	public void e2eApiTest() {

		HashMap<Object, Object> data = new HashMap<Object, Object>();
		data.put("email", "shubham@gmail.com");
		data.put("password", "Shubham@6855");
		
		Playwright ply = Playwright.create();
		APIRequestContext ApiRequest = ply.request().newContext( new APIRequest.NewContextOptions()
		        .setIgnoreHTTPSErrors(true));
		
		APIResponse loginResponse = ApiRequest.post("https://api.eventhub.rahulshettyacademy.com/api/auth/login",
				RequestOptions.create().setData(data));
		
		assertTrue(loginResponse.ok());
		
		System.out.println(loginResponse.text());

		System.out.println(loginResponse.status());
		
		
	}

}
