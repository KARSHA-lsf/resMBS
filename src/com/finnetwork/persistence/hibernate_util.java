package com.finnetwork.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class hibernate_util {  
	private static final SessionFactory sessionFactory;
	static {
		try {
		StandardServiceRegistry standardRegistry = 
		new StandardServiceRegistryBuilder().configure("resources/hibernate.cfg.xml").build();
		Metadata metaData = 
		new MetadataSources(standardRegistry).getMetadataBuilder().build();
			sessionFactory = metaData.getSessionFactoryBuilder().build();
		} catch (Throwable th) {

			System.err.println("Enitial SessionFactory creation failed" + th);
			throw new ExceptionInInitializerError(th);
		}
	}
	public static Session getSession() {
		final Session session = sessionFactory.openSession();
		return session;
	}
	public static void shutdown() {
		 sessionFactory.close();
	}
}
