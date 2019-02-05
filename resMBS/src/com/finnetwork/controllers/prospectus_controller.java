package com.finnetwork.controllers;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.finnetwork.models.prospectus;
import com.finnetwork.persistence.hibernate_util;

public class prospectus_controller {
public List <prospectus>  get_prospectus() {
	
		
		Session session = hibernate_util.getSession();
		 Transaction tx=session.beginTransaction();

		String hql = "SELECT PID,year,Prospectus,nominal_value_million,associated_topic FROM prospectus";
		Query query = session.createQuery(hql);
		List results = query.list();
		System.out.println(results.get(0));
		 tx.commit();
		 return results;
	}

public List <prospectus>  get_prospectusv3() {
	
	
	Session session = hibernate_util.getSession();
	 Transaction tx=session.beginTransaction();

	String hql = "SELECT PID,year,Prospectus,nominal_value_million,associated_topic FROM prospectusv3";
	Query query = session.createQuery(hql);
	List results = query.list();
	System.out.println(results.get(0));
	 tx.commit();
	 return results;
}

}
