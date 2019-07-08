package com.finnetwork.controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.finnetwork.models.bubble_graph;
import com.finnetwork.models.topic_mdl_issuers;
import com.finnetwork.persistence.hibernate_util;

//import test_abc.abc.bca.issuers;
//import test_abc.abc.bca.topic_mdl_securities;

public class topic_mdl_controller {
	
	public  topic_mdl_issuers get_issuers_given_id(int id) {
		topic_mdl_issuers ids=new topic_mdl_issuers();    
	        Configuration con=new Configuration().configure().addAnnotatedClass(topic_mdl_issuers.class);
	        SessionFactory sf=con.buildSessionFactory();
	        Session session =sf.openSession();
	        Transaction tx=session.beginTransaction();
	        
	        
	        ids=(topic_mdl_issuers)session. get(topic_mdl_issuers.class,id);
	        tx.commit();
	      
	        System.out.print("----->"+ids.getId()); 
	        return ids;
	}
	
	public ObjectNode getCompanyData() {
		System.out.println("Requested company data issuer ");

		Session session = hibernate_util.getSession();
		session.beginTransaction();
		Query querysource = session
				.createQuery("SELECT distinct concat(FI_Name,':',FI) as company FROM topic_mdl_issuers ");

		List sourceList = querysource.list();

		ObjectMapper mapper = new ObjectMapper();
		ArrayNode array = mapper.valueToTree(sourceList);
		ObjectNode companyNode = mapper.createObjectNode();
		companyNode.putArray("company").addAll(array);

		session.getTransaction().commit();
		session.close();
		// System.out.println("size of company records : "+companyNode.toString());
		return companyNode;
	}
	public ObjectNode get_count_Fi() {
		System.out.println("Requested company data issuer ");

		Session session = hibernate_util.getSession();
		session.beginTransaction();
		Query querysource = session
				.createQuery("SELECT COUNT(Fc),Fi FROM topic_mdl_issuers GROUP BY FC");

		List sourceList = querysource.list();

		ObjectMapper mapper = new ObjectMapper();
		ArrayNode array = mapper.valueToTree(sourceList);
		ObjectNode companyNode = mapper.createObjectNode();
		companyNode.putArray("company").addAll(array);

		session.getTransaction().commit();
		session.close();
		// System.out.println("size of company records : "+companyNode.toString());
		return companyNode;
	}
	public ObjectNode getIssuersDataForgivenData(String Fi) {
		
		Session session = hibernate_util.getSession();
		session.beginTransaction();
		Query querysource = session
				.createQuery("SELECT x.Fc,y.n,y.n_a,y.n_b,y.n_m FROM topic_mdl_issuers AS x , prospectus AS y WHERE x.Fi= :zz AND y.PID=x.Fc");
		//SELECT COUNT(Fc),Fi,year FROM topic_mdl_issuers WHERE Fi= :zz GROUP BY year 
		////SELECT x.FC,y.n FROM `topic_mdl_issuers` AS x ,`topic_mdl_prospectus` AS y WHERE x.FI='FI_34'AND y.PID=x.FC
		querysource.setParameter("zz", Fi);
		List sourceList = querysource.list();

		ObjectMapper mapper = new ObjectMapper();
		ArrayNode array = mapper.valueToTree(sourceList);
		ObjectNode companyNode = mapper.createObjectNode();
		companyNode.putArray("company").addAll(array);

		session.getTransaction().commit();
		session.close();
		
		return companyNode;
	}
	
public ObjectNode getIssuersDataForgivenData_v3(String Fi) {
		
		Session session = hibernate_util.getSession();
		session.beginTransaction();
		Query querysource = session
				.createQuery("SELECT x.Fc,y.Total as n ,y.A as n_a ,y.B as n_b,y.M as n_m FROM topic_mdl_issuers AS x , prospectusv3 AS y WHERE x.Fi= :zz AND y.PID=x.Fc");
		//SELECT COUNT(Fc),Fi,year FROM topic_mdl_issuers WHERE Fi= :zz GROUP BY year 
		////SELECT x.FC,y.n FROM `topic_mdl_issuers` AS x ,`topic_mdl_prospectus` AS y WHERE x.FI='FI_34'AND y.PID=x.FC
		querysource.setParameter("zz", Fi);
		List sourceList = querysource.list();

		ObjectMapper mapper = new ObjectMapper();
		ArrayNode array = mapper.valueToTree(sourceList);
		ObjectNode companyNode = mapper.createObjectNode();
		companyNode.putArray("company").addAll(array);

		session.getTransaction().commit();
		session.close();
		
		return companyNode;
	}
	
}
