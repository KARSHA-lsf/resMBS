package com.finnetwork.views;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.JsonNode;
import com.finnetwork.controllers.OC_controller;

@Path("/oc")
public class OC_data {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{companyName}")
	public Response getIBMNetwork(@PathParam("companyName") String companyName) {		
		System.out.println("Inside OC view...");
		
		OC_controller oc_controller = new OC_controller();
		JsonNode json_oc_network = oc_controller.get_OC(companyName);
		
		Response response = Response.ok(json_oc_network, MediaType.APPLICATION_JSON).build();		
		return response;		
	}
}
