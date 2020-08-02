package com.finnetwork.views;

import java.util.ArrayList;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.finnetwork.controllers.APP_controller;
import com.finnetwork.controllers.SEC_controller;
import com.finnetwork.controllers.Sankey_graph_controller;
import com.finnetwork.controllers.bubble_graph_controller;
import com.finnetwork.controllers.prospectus_controller;
import com.finnetwork.controllers.topic_mdl_controller;
import com.finnetwork.controllers.Sankey_graph_controller;
import com.finnetwork.models.topic_mdl_issuers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.finnetwork.models.OC_Link;
import com.finnetwork.models.OC_Node;
import com.finnetwork.models.TNIC2_Link;
import com.finnetwork.models.TNIC2_Node;
import com.finnetwork.models.Topic_mdl__sankey;

import antlr.collections.List;

import com.finnetwork.models.bubble_graph;
import com.finnetwork.models.prospectus;
@Path("/topic")
public class topic_mdl {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/issuers")
	public Response getBaseNetwork() {
		
		topic_mdl_controller to_m_c = new topic_mdl_controller(); 
		//to_m_c.getCompanyData();
		ObjectNode json_company_data = to_m_c.getCompanyData();
		Response response = Response.ok(json_company_data.toString(), MediaType.APPLICATION_JSON).build();	
		System.out.println(json_company_data.toString());
		return response;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/issuers_FI_FC")
	public Response Count_Fi_FC() {
		
		//System.out.println("------> ");
		topic_mdl_controller to_m_c = new topic_mdl_controller(); 
		
		ObjectNode json_company_data = to_m_c.get_count_Fi();
		Response response = Response.ok(json_company_data.toString(), MediaType.APPLICATION_JSON).build();	
		System.out.println(json_company_data.toString());
		return response;
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response getBaseNetworkYear(@PathParam("id") String id) {
		
		topic_mdl_controller to_m_c = new topic_mdl_controller();
		System.out.println("CCC ");
		System.out.print(id);
		JsonNode json_base_network_yearly = to_m_c.getIssuersDataForgivenData(id);
		
		Response response = Response.ok(json_base_network_yearly, MediaType.APPLICATION_JSON).build();		
		return response;
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("v3/{id}")
	public Response getBaseNetworkYear_v3(@PathParam("id") String id) {
		
		topic_mdl_controller to_m_c = new topic_mdl_controller();
		System.out.println("CCC ");
		System.out.print(id);
		JsonNode json_base_network_yearly = to_m_c.getIssuersDataForgivenData_v3(id);
		
		Response response = Response.ok(json_base_network_yearly, MediaType.APPLICATION_JSON).build();		
		return response;
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/bubble")
	public Response bubble_graph() {
		bubble_graph_controller bubble_graph = new bubble_graph_controller(); 
		bubble_graph bubble_model=new bubble_graph();
		
		//bubble_model
		ArrayList bubble_graph_list =(ArrayList) bubble_graph.get_bubble_given_id(1);
		System.out.println("------->>>>>issuers");
		Response response= Response.ok(bubble_graph_list,MediaType.APPLICATION_JSON).build();
		return response;
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/bubble/v3")
	public Response bubble_graph_v3() {
		bubble_graph_controller bubble_graph = new bubble_graph_controller(); 
		bubble_graph bubble_model=new bubble_graph();
		
		//bubble_model
		ArrayList bubble_graph_list =(ArrayList) bubble_graph.get_bubble_given_id(2);
		System.out.println("------->>>>>issuers");
		Response response= Response.ok(bubble_graph_list,MediaType.APPLICATION_JSON).build();
		return response;
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/prospectus")
	//import com.finnetwork.models.prospectus;
	public Response getProspectus() {
		prospectus_controller p_c = new prospectus_controller(); 
		prospectus prospectus=new prospectus();
		ArrayList prospectus_list=(ArrayList)p_c.get_prospectus();
    
		System.out.println("------->>>>>prospectus");
		Response response= Response.ok(prospectus_list,MediaType.APPLICATION_JSON).build();
		return response;
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/prospectus/v3")
	//import com.finnetwork.models.prospectus;
	public Response getProspectusv3() {
		prospectus_controller p_c = new prospectus_controller(); 
		prospectus prospectus=new prospectus();
		ArrayList prospectus_list=(ArrayList)p_c.get_prospectusv3();
    
		System.out.println("------->>>>>prospectus");
		Response response= Response.ok(prospectus_list,MediaType.APPLICATION_JSON).build();
		return response;
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/sankey/{year}")
	public Response bubble_sankey(@PathParam("year") String year) {
		Sankey_graph_controller sankey = new Sankey_graph_controller();
		ObjectNode sankey_list =(ObjectNode) sankey.get_sankey_data(year);
		
		System.out.println("AAAAAAAAAAAAAAAAAA-------->"+year);
		
		
		
		/*ObjectMapper objectMapper = new ObjectMapper();
		ArrayNode arrayNode = objectMapper.valueToTree(oc_nodes);
		ArrayNode arrayLink = objectMapper.valueToTree(oc_edges);
		ObjectNode base_network = objectMapper.createObjectNode();
		base_network.putArray("nodes").addAll(arrayNode);
		base_network.putArray("links").addAll(arrayLink);*/
		
		
		Response response= Response.ok(sankey_list,MediaType.APPLICATION_JSON).build();
		return response;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/sankey/v3/{year}")
	public Response bubble_sankeyv3(@PathParam("year") String year) {
		Sankey_graph_controller sankey = new Sankey_graph_controller();
		ObjectNode sankey_list =(ObjectNode) sankey.get_sankey_data(year);
		
		System.out.println("AAAAAAAAAAAAAAAAAA-------->"+year);
		
		
		
		/*ObjectMapper objectMapper = new ObjectMapper();
		ArrayNode arrayNode = objectMapper.valueToTree(oc_nodes);
		ArrayNode arrayLink = objectMapper.valueToTree(oc_edges);
		ObjectNode base_network = objectMapper.createObjectNode();
		base_network.putArray("nodes").addAll(arrayNode);
		base_network.putArray("links").addAll(arrayLink);*/
		
		
		Response response= Response.ok(sankey_list,MediaType.APPLICATION_JSON).build();
		return response;
	}
	
}
