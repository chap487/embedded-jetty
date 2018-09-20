package com.example;

//import javax.net.ssl.SSLEngineResult.Status;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

//import net.smartlab.web.DataTransferObject;


@Path("calculator")
public class Calculator {
	
	public Calculator() {}
	
    @GET
    @Path("BlackScholes")
    @Produces(MediaType.APPLICATION_JSON)
    public OptionDetails BlackScholes(@QueryParam("input") String jsonString){
    	
    	OptionDetails optionDetails = OptionDetails.fromJson(jsonString);
		BlackScholes.calculateWithGreeks(optionDetails);
    	
        return optionDetails;
    }

 }
