package com.finnetwork.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.finnetwork.models.OC_Link;
import com.finnetwork.models.OC_Node;
import com.finnetwork.models.TNIC2_Link;
import com.finnetwork.models.TNIC2_Node;
import com.finnetwork.persistence.hibernate_util;

public class OC_controller {

	public ObjectNode get_OC(String comapany_id) {

			Session session = hibernate_util.getSession();
			session.beginTransaction();

			Query querysource = session
					.createQuery("FROM OC_Link WHERE OC_SUBJECT_ID = :comapany_id ");
			querysource.setParameter("comapany_id", comapany_id);
			List<OC_Link> oc_edges = querysource.list();
			
			OC_controller oc_con = new OC_controller();
			Set<String> nodeSet = oc_con.node_list(oc_edges);
			
			Query querynodes =session.createQuery("FROM OC_Node WHERE OC_ID in (:companies) and OC_ENTITY_TYPE = 'company'");
			querynodes.setParameterList("companies", nodeSet);
			List<OC_Node> oc_nodes = querynodes.list();
			
			ObjectMapper objectMapper = new ObjectMapper();
			ArrayNode arrayNode = objectMapper.valueToTree(oc_nodes);
			ArrayNode arrayLink = objectMapper.valueToTree(oc_edges);
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

		public Set<String> node_list(List<OC_Link> nodes){
			Set<String> node_set = new HashSet<>();
			for (OC_Link entity : nodes) {
				node_set.add(entity.getOC_SUBJECT_ID());
				node_set.add(entity.getOC_OBJECT_ID());
			}
			System.out.println("oc nodes :"+node_set.size());
			return node_set;
		}
	}

