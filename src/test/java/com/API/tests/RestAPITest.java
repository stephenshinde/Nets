package com.API.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.Utility.API.GetPayouts;
import com.Utility.API.JsonPathUtility;
import com.automation.helpers.ReportHelper;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


public class RestAPITest extends Base {
	@Test
	public void VerifySingleUserAPI() throws Exception{
		ReportHelper.extenttest = ReportHelper.addTestCasename("Single User API ", "Verify Single User API with valid data");
		String response =given().header("Content-Type","application/json").
				
				// get method with resource
				when().get("report/v1/payouts").
				// Assertion
				then().assertThat().statusCode(200).
				assertThat().header("Content-Type", "application/json").
				//Extract response as string
				extract().response().asString();
				// get EMail address from the response
				JsonPath js= JsonPathUtility.convertjson(response);
				String numberOfPayouts = js.getString("numberOfPayouts");
				System.out.println(numberOfPayouts);
				
				
				AssertJUnit.assertEquals(js.getString("payouts[0].id"), "11ebb9ef6a7d4df0b20d59ad574e9761");
				AssertJUnit.assertEquals(js.getString("payouts[1].id"), "014d000060a6cb7b8f5e642e3ca552b0");
				
				AssertJUnit.assertEquals(js.getString("payouts[0].date"), "2021-05-21");
				AssertJUnit.assertEquals(js.getString("payouts[1].date"), "2022-05-22");
				
				
				

		
	}
	


	@Test
	public void VerifySingleUserwithInvalidResource() throws Exception{
		ReportHelper.extenttest = ReportHelper.addTestCasename("Single User with Invalid resource ", "Verify Single User API with invalid resource path");
		Response response =given().header("Content-Type","application/json").
				
				// get method with resource
				when().get("https://relay-candidate.proxy.beeceptor.com/%report/v1/payouts");
				
				System.out.println(response.getStatusLine());
				System.out.println(response.getStatusCode());
				//then().log().all();
				
//				response.statusCode(404);
//				response.getstatus

			
		
	}
	
	@Test
	public void CreateUser() {
		ReportHelper.extenttest = ReportHelper.addTestCasename("Create User", "Verify Create User API with valid data");
		
			GetPayouts gp =given().header("Content-Type","application/json").
				
				// get method with resource
				when().get("report/v1/payouts").as(GetPayouts.class);
			String id = gp.payouts.get(0).getId();
			System.out.println(id);
			ValidatableResponse response = given().header("Content-Type","application/json").
					queryParam("id", id).
					when().get("report/v1/payouts").
					then().log().all();
	}

	
	

}
