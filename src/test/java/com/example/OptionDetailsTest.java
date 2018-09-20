package com.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OptionDetailsTest {

	@Test
	public void testToString() {
		OptionDetails optionDetails = new OptionDetails(true, 100, 105, 0.02, 0.25, 0.12);
		String expected = "spot price[100.0] strike[105.0] int rate[0.02] expire[0.25] vol[0.12] " + 
				"option value[0.0] delta[0.0] theta[0.0] rho[0.0] gamma[0.0] vega[0.0]";
		
		assertTrue(optionDetails.toString().equals(expected));
	}

	@Test
	public void testToJson() {
		OptionDetails optionDetails = new OptionDetails(true, 100, 105, 0.02, 0.25, 0.12);
		String expected = optionDetails.toJson(optionDetails);
		
		System.out.println(expected);
		
		assertTrue(OptionDetails.toJson(optionDetails).equals(expected));
	}

	

	@Test
	public void testFromJson() {
		OptionDetails expected = new OptionDetails(true, 100, 105, 0.02, 0.25, 0.12);
		String jsonString = "{\"callOption\":true,\"spotPriceOfUnderlying\":100.0,\"strikePrice\":105.0,\"riskFreeInterestRate\":0.02,\"timeToExpire\":0.25,\"volatility\":0.12,\"optionValue\":0.0,\"delta\":0.0,\"theta\":0.0,\"rho\":0.0,\"gamma\":0.0,\"vega\":0.0}";
		OptionDetails optionDetails = OptionDetails.fromJson(jsonString);
		
		assertTrue(expected.equals(optionDetails));
	}
	
	@Test
	public  void testCalculateWithGreeks() {
		OptionDetails optionDeatils = new OptionDetails(true, 105, 105, 0.02, 0.25, 0.12);
		BlackScholes.calculateWithGreeks(optionDeatils);
		System.out.println(optionDeatils.toString());
	}

}
