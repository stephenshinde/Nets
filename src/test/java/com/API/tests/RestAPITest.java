package com.API.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.Utility.API.GetPayouts;
import com.Utility.API.JsonPathUtility;
import com.automation.helpers.ReportHelper;

import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;


public class RestAPITest extends Base {
	SoftAssert aSoftAssert = new SoftAssert();

	/* Verify status code, status message and response header of payout API */
	@Test
	public void VerifyStatuscodeMessageforPayoutAPI() throws Exception{
		ReportHelper.extenttest = ReportHelper.addTestCasename("VerifyStatuscodeMessageforPayoutAPI", "To Verify status code, status message, respopnse header of the Payout API");
		
		given().header("Content-Type","application/json").
				
				/* Get method with resource path */
				when().get(reader.getResourcePath()).
				/* print response in console */
				then().log().all().
				/* Verify status code and status message */
				assertThat().statusCode(200).and().statusLine("HTTP/1.1 200 OK").
				/* verify content type header from the response */
				assertThat().header("Content-Type", "application/json");
		
	}
	
	/* To verify number of payouts, id and date from the Payout API */
	@Test
	public void VerifyResponseProperty_PayoutAPI() throws Exception{
		ReportHelper.extenttest = ReportHelper.addTestCasename("VerifyResponseProperty_PayoutAPI", "To verify number of payouts,id and date from the Payout API");
		String response =given().header("Content-Type","application/json").
				
				/* Get method with resource path */
				when().get(reader.getResourcePath()).
				then().
				
				//Extract response as string
				extract().response().asString();
				/* Deserialize response using Json path library */
				JsonPath js= JsonPathUtility.convertjson(response);
				
				/* Fetch value for numberOfPayouts and verify with expected result*/
				aSoftAssert.assertEquals(js.getString("numberOfPayouts"), "2");
				
				/* Fetch value for Payouts Id and verify with expected result*/
				aSoftAssert.assertEquals(js.getString("payouts[0].id"), "11ebb9ef6a7d4df0b20d59ad574e9761");
				aSoftAssert.assertEquals(js.getString("payouts[1].id"), "014d000060a6cb7b8f5e642e3ca552b0");
				
				/* Fetch value for Date and verify with expected result*/
				aSoftAssert.assertEquals(js.getString("payouts[0].date"), "2021-05-21");
				/* This test case will fail; because in the response date format is not expected */
				aSoftAssert.assertEquals(js.getString("payouts[1].date"), "2022-05-22");
				
				aSoftAssert.assertAll();
				ReportHelper.extenttest.info("I login with locked out  user");
		
	}
	
	/* Verify Payouts API response when URI and resource path is wrong */
	@Test
	public void VerifyPayoutsAPIwithInvalidResource() throws Exception{
		ReportHelper.extenttest = ReportHelper.addTestCasename("VerifyPayoutsAPIwithInvalidResource ", "Verify Payouts API response when URI and resource path is wrong");
		
			
				given().header("Content-Type","application/json").
						
				/*
				 * if we use wrong URI path and wrong resource path that time we should expect
				 * Status code 404
				 */
						when().get(reader.getInvalidURIResourcePath()).
						//Verify status code 404 and status message when URI and resource path is wrong
						then().assertThat().statusCode(404).and().statusLine("HTTP/1.1 404 Not Found");
	}
	
	/*
	 * Fetch id value from Payout API & pass same id to retrive payout API and
	 * verify property value
	 */
	@Test
	public void CreateUser() {
		ReportHelper.extenttest = ReportHelper.addTestCasename("Create User", "Verify Create User API with valid data");
		
			GetPayouts gp =given().header("Content-Type","application/json").
				
			/* Get method with payout resource path */
			when().get(reader.getResourcePath()).as(GetPayouts.class);
			/* Get Id value from payouts API */
			String id = gp.payouts.get(0).getId();
			System.out.println(id);
			
			String response =given().header("Content-Type","application/json").
			        /* Pass above fetch id value to payout details API as query parameter */
					queryParam("id", id).
					/* Get method with resource path */
					when().get("report/v1/payouts").
					then().
					/* Verify status code and expected status code should be 200 */
					assertThat().statusCode(200).
					/* Verify Content type from response header */
					assertThat().header("Content-Type", "application/json").
					/* Extract response as string */
					extract().response().asString();
			       /* Deserialize response using Json path library */
					JsonPath js= JsonPathUtility.convertjson(response);
					/* Verify Payout response id with Payout details id */
					aSoftAssert.assertEquals(js.getString("id"), gp.payouts.get(0).getId());
					/* Verify Payout response reference with Payout details reference */
					aSoftAssert.assertEquals(js.getString("reference"), gp.payouts.get(0).getReference());
					/* Verify Payout response date with Payout details date */
					aSoftAssert.assertEquals(js.getString("date"), gp.payouts.get(0).getDate());
					/* Verify Payout response Bank Account Iban with Payout details Bank Account Iban */
					aSoftAssert.assertEquals(js.getString("bankAccountIban"), gp.payouts.get(0).getBankAccountIban());
					/* Verify Payout response Bank Account BIC with Payout details Bank Account BIC */
					aSoftAssert.assertEquals(js.getString("bankAccountBic"), gp.payouts.get(0).getBankAccountBic());
					/* Verify Payout response Currency with Payout details Currency */
					aSoftAssert.assertEquals(js.getString("currency"), gp.payouts.get(0).getCurrency());
					/* Verify Payout response amout with Payout details amount */
					aSoftAssert.assertEquals(js.getString("amount"), gp.payouts.get(0).getAmount());
					/* Verify Payout response chargedAmount with Payout details chargedAmount */
					aSoftAssert.assertEquals(js.getString("chargedAmount"), gp.payouts.get(0).getChargedAmount());
					/* Verify Payout response refundedAmount with Payout details refundedAmount */
					aSoftAssert.assertEquals(js.getString("refundedAmount"), gp.payouts.get(0).getRefundedAmount());
					
					aSoftAssert.assertAll();
					
					
					
	}
	
	/* Verify Retrive Payout Details API when we pass blank id */
	@Test
	public void RetrivePayoutDetailswithBlankId() {
		ReportHelper.extenttest = ReportHelper.addTestCasename("RetrivePayoutDetailswithBlankId", "Verify Retrive Payout Details API with blank id");
					given().header("Content-Type","application/json").
					/* passing blank value for Id query parameters */
					queryParam("id", "").
					
					/* Get method with resource path */
					when().get(reader.getResourcePath()).
					// Assertion
					then().
							/*
							 * when we pass blank value in that case we are expected error code is 500 internal service error
							 * But in actual result we are getting 200 status code
							 */
					assertThat().statusCode(500).
					assertThat().header("Content-Type", "application/json");
					
					
	}
	
	
	

	
	

}
