package com.finnetwork.views;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//import org.eclipse.jdt.internal.compiler.flow.InsideSubRoutineFlowContext;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.finnetwork.controllers.SEC_controller;
import com.finnetwork.controllers.TNIC2_controller;

@Path("/sec")
public class SEC_data {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{companyName}")
	public Response getBaseNetwork(@PathParam("companyName") String companyName,@DefaultValue("ALL")@QueryParam("Role") String role) {
		System.out.println("inside getBaseNetwork");
		SEC_controller sec_controller = new SEC_controller();
		JsonNode json_base_network = sec_controller.getBaseNetwork(companyName,role);		
		
		Response response = Response.ok(json_base_network, MediaType.APPLICATION_JSON).build();		
		return response;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{companyName}/{year}")
	public Response getBaseNetworkYear(@PathParam("companyName") String companyName, @PathParam("year") int year,@DefaultValue("ALL")@QueryParam("Role") String role) {
		System.out.println("inside getBaseNetworkYear");
		SEC_controller sec_controller = new SEC_controller();
		JsonNode json_base_network_yearly = sec_controller.getDataYearWise(companyName, year,role);
		
		Response response = Response.ok(json_base_network_yearly, MediaType.APPLICATION_JSON).build();		
		return response;
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/company")
	public Response getCompanyData(){
		SEC_controller sec_controller = new SEC_controller();
		ObjectNode json_company_data = sec_controller.getCompanyData();
		Response response = Response.ok(json_company_data.toString(), MediaType.APPLICATION_JSON).build();	
		System.out.println(json_company_data.toString());
		return response;
	}
}
