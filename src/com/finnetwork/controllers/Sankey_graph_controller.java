package com.finnetwork.controllers;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.finnetwork.models.APP_Link;
import com.finnetwork.models.Topic_mdl__sankey;
import com.finnetwork.persistence.hibernate_util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.finnetwork.models.OC_Link;
import com.finnetwork.models.OC_Node;
import com.finnetwork.models.TNIC2_Link;
import com.finnetwork.models.TNIC2_Node;
import com.finnetwork.persistence.hibernate_util;

class link {
	private int source;
	private int target;
	private double value;

	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

}

class node {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

public class Sankey_graph_controller {
public ObjectNode  get_sankey_data(String year) {
		Session session = hibernate_util.getSession();
		 Transaction tx=session.beginTransaction();
		
		String hql = "SELECT FI_Name,FI,nominal_value_million,associated_topic FROM Topic_mdl__sankey WHERE Year = :year ";
		 //String hql = "SELECT FI_Name FROM Topic_mdl__sankey WHERE Year = :year ";
		Query query = session.createQuery(hql);
		query.setParameter("year",Integer.parseInt(year) );
		List results = query.list();
		
 
		
		
		
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayNode arrayNode = objectMapper.valueToTree(results);
		
		
		 ArrayList<node> node_list = new ArrayList<node>();
		 ArrayList<link> links = new ArrayList<link>();
		int count=0;
		for(int i=0;i<arrayNode.size();i++) {
			//System.out.println(arrayNode.get(i).get(2).asDouble());
			
			
			boolean isInNode_list_FI_Name=false;
			int index_Innode_list_FI_Name=-1;
			
			boolean isInNode_list_Topic_Name=false;
			int index_Innode_list_Topic_Name=-1;
			
			link link=new link();
			for(int x =0;x<node_list.size();x++) {
				if(node_list.get(x).getName().equals(arrayNode.get(i).get(0).asText())) {
					isInNode_list_FI_Name=true;
					index_Innode_list_FI_Name=x;
				}
				if(node_list.get(x).getName().equals(arrayNode.get(i).get(3).asText())) {
					 isInNode_list_Topic_Name=true;
					 index_Innode_list_Topic_Name=x;
				}
				
			}
			if(!isInNode_list_FI_Name) {
				node node_1=new node();
				node_1.setName(arrayNode.get(i).get(0).asText());
				node_list.add(node_1);
				link.setSource(node_list.size()-1);//---
			}else {
				if(index_Innode_list_FI_Name<0) {System.out.println("Errorr index_Innode_list_FI_Name<0 @@@@@@@@@");}
				link.setSource(index_Innode_list_FI_Name);
			}
			
			if(!isInNode_list_Topic_Name) {
				node node_2=new node();
				node_2.setName(arrayNode.get(i).get(3).asText());
				node_list.add(node_2);
				link.setTarget(node_list.size()-1);
			}else {
				if(index_Innode_list_Topic_Name<0) {System.out.println("Errorr index_Innode_list_Topic_Name<0 @@@@@@@@@");}
				link.setTarget(index_Innode_list_Topic_Name);
			}
			
			
			
			//link.setSource(count);
			//count=count+1;
			//link.setTarget(count);
			//count=count+1;
		     
			link.setValue(arrayNode.get(i).get(2).asDouble());
			links.add(link);
		}
		
		
		
		ArrayNode arrayNode_a = objectMapper.valueToTree(node_list);
		ArrayNode arrayLink_b = objectMapper.valueToTree(links);
		
		ObjectNode base_network = objectMapper.createObjectNode();
		base_network.putArray("nodes").addAll(arrayNode_a);
		base_network.putArray("links").addAll(arrayLink_b);
		
		
		System.out.println(base_network);
		
		
		
		
		 tx.commit();
		 return base_network;
	}
}