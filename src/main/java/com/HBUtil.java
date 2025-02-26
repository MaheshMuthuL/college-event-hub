package com;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;



public class HBUtil {
   private static StandardServiceRegistry registry;
   private static SessionFactory session;
   public static SessionFactory getSessionFactory() {
	    try {
	        registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
	        Metadata md = new MetadataSources(registry).buildMetadata();
	        session = md.buildSessionFactory();
	        return session;
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException("Error initializing Hibernate session factory");
	    }
	}

}