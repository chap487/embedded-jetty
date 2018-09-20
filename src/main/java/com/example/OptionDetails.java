package com.example;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * Option details data class
 */
public class OptionDetails { // extends OptionDetailsInputs{ //implements Serializable {

	public boolean callOption;
	public double spotPriceOfUnderlying;
	public double strikePrice;
	public double riskFreeInterestRate;
	public double timeToExpire;
	public double volatility;

	public double optionValue;
	public double delta;
	public double theta;
	public double rho;
	public double gamma;
	public double vega;
	 
	public OptionDetails() {};

	public OptionDetails(boolean call, double s, double k, double r, double t, double v) {
		callOption = call;
		spotPriceOfUnderlying = s;
		strikePrice = k;
		riskFreeInterestRate = r;
		timeToExpire = t;
		volatility = v;
	}

	public static String toJson(OptionDetails optionDetails) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = null;
		
		//Convert object to JSON string
		try {
			jsonInString = mapper.writeValueAsString(optionDetails);
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return jsonInString;
	}
	

	public static OptionDetails fromJson(String jsonString) {
		ObjectMapper mapper = new ObjectMapper();
		
		OptionDetails optionDetails = null;
		//Convert  JSON string to object JSON string
		try {
			optionDetails = mapper.readValue(jsonString, OptionDetails.class);
			System.out.println(jsonString);
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return optionDetails;
	}
	
	public String toString() {
		
		String out = "spot price[" + spotPriceOfUnderlying + "] strike[";
		out += strikePrice + "] int rate[" + riskFreeInterestRate + "] expire[";
		out += timeToExpire + "] vol[" + volatility + "] ";

		out += "option value[" + optionValue + "] delta[" + delta + "] theta[";
		out += theta + "] rho[" + rho + "] gamma[" + gamma + "] vega[" + vega + "]";
		
		return out;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (callOption ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(delta);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(gamma);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(optionValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(rho);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(riskFreeInterestRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(spotPriceOfUnderlying);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(strikePrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(theta);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(timeToExpire);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(vega);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(volatility);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OptionDetails other = (OptionDetails) obj;
		if (callOption != other.callOption)
			return false;
		if (Double.doubleToLongBits(delta) != Double.doubleToLongBits(other.delta))
			return false;
		if (Double.doubleToLongBits(gamma) != Double.doubleToLongBits(other.gamma))
			return false;
		if (Double.doubleToLongBits(optionValue) != Double.doubleToLongBits(other.optionValue))
			return false;
		if (Double.doubleToLongBits(rho) != Double.doubleToLongBits(other.rho))
			return false;
		if (Double.doubleToLongBits(riskFreeInterestRate) != Double.doubleToLongBits(other.riskFreeInterestRate))
			return false;
		if (Double.doubleToLongBits(spotPriceOfUnderlying) != Double.doubleToLongBits(other.spotPriceOfUnderlying))
			return false;
		if (Double.doubleToLongBits(strikePrice) != Double.doubleToLongBits(other.strikePrice))
			return false;
		if (Double.doubleToLongBits(theta) != Double.doubleToLongBits(other.theta))
			return false;
		if (Double.doubleToLongBits(timeToExpire) != Double.doubleToLongBits(other.timeToExpire))
			return false;
		if (Double.doubleToLongBits(vega) != Double.doubleToLongBits(other.vega))
			return false;
		if (Double.doubleToLongBits(volatility) != Double.doubleToLongBits(other.volatility))
			return false;
		return true;
	}

	public boolean isCallOption() {
		return callOption;
	}

	public void setCallOption(boolean callOption) {
		this.callOption = callOption;
	}

	public double getSpotPriceOfUnderlying() {
		return spotPriceOfUnderlying;
	}

	public void setSpotPriceOfUnderlying(double spotPriceOfUnderlying) {
		this.spotPriceOfUnderlying = spotPriceOfUnderlying;
	}

	public double getStrikePrice() {
		return strikePrice;
	}

	public void setStrikePrice(double strikePrice) {
		this.strikePrice = strikePrice;
	}

	public double getRiskFreeInterestRate() {
		return riskFreeInterestRate;
	}

	public void setRiskFreeInterestRate(double riskFreeInterestRate) {
		this.riskFreeInterestRate = riskFreeInterestRate;
	}

	public double getTimeToExpire() {
		return timeToExpire;
	}

	public void setTimeToExpire(double timeToExpire) {
		this.timeToExpire = timeToExpire;
	}

	public double getVolatility() {
		return volatility;
	}

	public void setVolatility(double volatility) {
		this.volatility = volatility;
	}

	public double getOptionValue() {
		return optionValue;
	}

	public void setOptionValue(double optionValue) {
		this.optionValue = optionValue;
	}

	public double getDelta() {
		return delta;
	}

	public void setDelta(double delta) {
		this.delta = delta;
	}

	public double getTheta() {
		return theta;
	}

	public void setTheta(double theta) {
		this.theta = theta;
	}

	public double getRho() {
		return rho;
	}

	public void setRho(double rho) {
		this.rho = rho;
	}

	public double getGamma() {
		return gamma;
	}

	public void setGamma(double gamma) {
		this.gamma = gamma;
	}

	public double getVega() {
		return vega;
	}

	public void setVega(double vega) {
		this.vega = vega;
	}


}
