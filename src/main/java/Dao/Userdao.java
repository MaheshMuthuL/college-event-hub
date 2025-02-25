package Dao;

import org.hibernate.Session;

import com.HBUtil;

import database_classes.login;

public class Userdao {
	
	public void save(login user) {
		try(Session ses=HBUtil.getSesssionFactory().openSession()){
			ses.beginTransaction();
			ses.persist(user);
			ses.getTransaction().commit();		
		}
	}
	public boolean logincheck (String email,String pass) {
		try(Session ses=HBUtil.getSesssionFactory().openSession()){
			String hql="from login where email=:emailid and pass=:pass";
		login user=ses.createQuery(hql,login.class).setParameter("emailid", email).setParameter("pass", pass).getSingleResult();
			System.out.println(user);
			return user !=null;
			
		}
	}

}
