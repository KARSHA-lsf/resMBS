package com.finnetwork.views;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.JsonNode;
import com.finnetwork.controllers.APP_controller;
import com.finnetwork.controllers.base_network_cntrl;

// Every url with the format of base_url/base_network will be directed to this class
@Path("/APP")
public class APP_data {
	
	
	@GET
	@Path("/{cik}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getResponse (@PathParam("cik") String cik){
		APP_controller app_con = new APP_controller(); 
		//	Call the relevant method with requested year parameter 
		JsonNode json_baseNet = app_con.getAppNetwork(cik);
		
	
		
		//	Create a Response and return a JSON with status code 200 OK
		Response response = Response.ok(json_baseNet, MediaType.APPLICATION_JSON).build();		
		return response;
	
	}
}
