package com;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;



public class HBUtil {
   private static StandardServiceRegistry registry;
   private static SessionFactory session;
   public static SessionFactory getSesssionFactory() {
	   registry=new StandardServiceRegistryBuilder().configure("Hibernate.cfg.xml").build();
	   Metadata md=new MetadataSources(registry).buildMetadata();
	   session=md.buildSessionFactory();
	   return session;
   }
}
