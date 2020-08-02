package com.finnetwork.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.finnetwork.models.APP_Link;
import com.finnetwork.models.APP_Node;
import com.finnetwork.models.TNIC2_Link;
import com.finnetwork.models.TNIC2_Node;
import com.finnetwork.models.TRDF_gt_Link;
import com.finnetwork.models.TRDF_gt_Link211;
import com.finnetwork.models.TRDF_gt_Node;
import com.finnetwork.persistence.hibernate_util;

public class APP_controller {

	public JsonNode getAppNetwork(String cik) {
		System.out.println("Requested company APP : " + cik );

		Session session = hibernate_util.getSession();
		session.beginTransaction();

		Query querysource = session
				.createQuery("FROM APP_Link t WHERE CIK_1 = :cik");
		querysource.setParameter("cik", cik);
		
		List<APP_Link> app_edges = querysource.list();
		
//		for (APP_Link app_Link : app_edges) {
//			System.out.println("LLL : "+app_Link.getCIK_1());
//		}
		
		
		
		APP_controller app_con = new APP_controller();
		Set<String> nodeSet = app_con.node_list(app_edges);
		
		
		Query querynodes =session.createQuery("FROM APP_Node WHERE cik in(:ids)");
		querynodes.setParameterList("ids", nodeSet);
		List<APP_Node> app_nodes = querynodes.list();
		System.out.println("uuuuuuu : "+app_nodes.size());
		
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayNode arrayNode = objectMapper.valueToTree(app_nodes);
		ArrayNode arrayLink = objectMapper.valueToTree(app_edges);
		ObjectNode base_network = objectMapper.createObjectNode();
		base_network.putArray("nodes").addAll(arrayNode);
		base_network.putArray("links").addAll(arrayLink);
		
		session.getTransaction().commit();
		session.close();
		
		return base_network;
	}
	
	public Set<String> node_list(List<APP_Link> nodes){
		Set<String> node_set = new HashSet<>();
		for (APP_Link entity : nodes) {
			//System.out.println("oooo "+ entity.getSource());
			node_set.add(entity.getCIK_1());
			node_set.add(entity.getCIK_2());
		}
		System.out.println("lllllllllll :"+node_set.size()+" : "+nodes.size());
		return node_set;
	}

	
}
