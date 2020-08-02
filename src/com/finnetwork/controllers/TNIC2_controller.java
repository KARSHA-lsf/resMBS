package com.finnetwork.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.finnetwork.models.TNIC2_Link;
import com.finnetwork.models.TNIC2_Node;
import com.finnetwork.models.TR_Link;
import com.finnetwork.models.TR_Node;
import com.finnetwork.persistence.hibernate_util;

public class TNIC2_controller {
	public ObjectNode getBaseNetwork_annual_Sec51(String cik) {
		System.out.println("Requested company TNIC2: " + cik + " ");

		Session session = hibernate_util.getSession();
		session.beginTransaction();

		Query querysource = session
				.createQuery("FROM TNIC2_Link WHERE (CIK_1 = :cik ) AND (year= 2013 OR year =2014 OR year=2015)");
		querysource.setParameter("cik", cik);
	
		List<TNIC2_Link> tnic2_edges = querysource.list();
		
		TNIC2_controller tnic_con = new TNIC2_controller();
		Set<String> nodeSet = tnic_con.node_list(tnic2_edges);
		
		Query querynodes =session.createQuery("FROM TNIC2_Node WHERE cik in(:ciks)");
		querynodes.setParameterList("ciks", nodeSet);
		List<TNIC2_Node> tnic2_nodes = querynodes.list();
		
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayNode arrayNode = objectMapper.valueToTree(tnic2_nodes);
		ArrayNode arrayLink = objectMapper.valueToTree(tnic2_edges);
		ObjectNode base_network = objectMapper.createObjectNode();
		base_network.putArray("nodes").addAll(arrayNode);
		base_network.putArray("links").addAll(arrayLink);
		session.getTransaction().commit();
		session.close();
		return base_network;
	}
	
	
	public ObjectNode getBaseNetwork_annual_Sec51(String cik, String nodup) {
		System.out.println("ppppppppppppppppppppppppppp");

		Session session = hibernate_util.getSession();
		session.beginTransaction();

		Query querysource = session
				.createQuery("FROM TNIC2_Link WHERE (CIK_1 = :cik ) AND (year= 2013 OR year =2014 OR year=2015)");
		querysource.setParameter("cik", cik);
		List<TNIC2_Link> tnic2_edges = querysource.list();
		List<TNIC2_Link> tnic2_edges_final = new ArrayList<>();
		
		Set<String> distinct_edges = new HashSet<String>();
		for (TNIC2_Link t : tnic2_edges) {
			distinct_edges.add(t.getCIK_1()+"-"+t.getCIK_2());
		}
		List<String> distinct_edges_list = new ArrayList<String>(distinct_edges);
		
		for (int i = 0; i < distinct_edges_list.size(); i++) {
			for (TNIC2_Link t : tnic2_edges) {
				String tmp = t.getCIK_1()+"-"+t.getCIK_2();
				if(tmp.equals(distinct_edges_list.get(i))) {
					tnic2_edges_final.add(t);
					break;
				}
			}
		}
		//System.out.println(tnic2_edges.size()+"OOOOOOOOOOOOOOOO"+distinct_edges.size());
		System.out.println("kkkkkkkkkkkkkkkkkkkkkkk : "+tnic2_edges_final.size());
		
		TNIC2_controller tnic_con = new TNIC2_controller();
		Set<String> nodeSet = tnic_con.node_list(tnic2_edges_final);
		
		
		
		Query querynodes =session.createQuery("FROM TNIC2_Node WHERE cik in(:ciks)");
		querynodes.setParameterList("ciks", nodeSet);
		List<TNIC2_Node> tnic2_nodes = querynodes.list();
		
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayNode arrayNode = objectMapper.valueToTree(tnic2_nodes);
		ArrayNode arrayLink = objectMapper.valueToTree(tnic2_edges_final);
		ObjectNode base_network = objectMapper.createObjectNode();
		base_network.putArray("nodes").addAll(arrayNode);
		base_network.putArray("links").addAll(arrayLink);
		session.getTransaction().commit();
		session.close();
		return base_network;
	}
	
	
	public ObjectNode getBaseNetwork_annual(String cik, int year) {
		System.out.println("Requested company TNIC2: " + cik + " " + year);

		Session session = hibernate_util.getSession();
		session.beginTransaction();

		Query querysource = session
				.createQuery("FROM TNIC2_Link WHERE (CIK_1 = :cik ) AND year= :year");
		querysource.setParameter("cik", cik);
		querysource.setParameter("year", year);
		List<TNIC2_Link> tnic2_edges = querysource.list();
		
		TNIC2_controller tnic_con = new TNIC2_controller();
		Set<String> nodeSet = tnic_con.node_list(tnic2_edges);
		
		Query querynodes =session.createQuery("FROM TNIC2_Node WHERE cik in(:ciks)");
		querynodes.setParameterList("ciks", nodeSet);
		List<TNIC2_Node> tnic2_nodes = querynodes.list();
		
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayNode arrayNode = objectMapper.valueToTree(tnic2_nodes);
		ArrayNode arrayLink = objectMapper.valueToTree(tnic2_edges);
		ObjectNode base_network = objectMapper.createObjectNode();
		base_network.putArray("nodes").addAll(arrayNode);
		base_network.putArray("links").addAll(arrayLink);
		session.getTransaction().commit();
		session.close();
		return base_network;
	}

	public ObjectNode getCompanyData() {
		System.out.println("Requested company data TNIC2 ");

		Session session = hibernate_util.getSession();
		session.beginTransaction();
		Query querysource = session
				.createQuery("SELECT concat(ticker_symbol,' : ' ,security,' : ' ,gics_Sector,' : ' ,gics_sub_Industry,'  cik: ' ,cik,' naics: ' ,naics) as company FROM TNIC2_Node");

		List sourceList = querysource.list();

		ObjectMapper mapper = new ObjectMapper();
		// List<Employee> e = new ArrayList<Employee>();
		ArrayNode array = mapper.valueToTree(sourceList);
		ObjectNode companyNode = mapper.createObjectNode();
		companyNode.putArray("company").addAll(array);

		session.getTransaction().commit();
		session.close();
		// System.out.println("size of company records : "+companyNode.toString());
		return companyNode;
	}

	public Set<String> node_list(List<TNIC2_Link> nodes){
		Set<String> node_set = new HashSet<>();
		for (TNIC2_Link entity : nodes) {
			node_set.add(entity.getCIK_1());
			node_set.add(entity.getCIK_2());
		}
		System.out.println("lllllllllll :"+node_set.size());
		return node_set;
	}
}
