	package Dao;
	
	import org.hibernate.Session;
	
	import com.HBUtil;
	
	import database_classes.Login;
	
	public class Userdao {
		
		public void save(Login user) {
			System.out.println("getting into save function");
			try(Session ses=HBUtil.getSessionFactory().openSession()){
				System.out.println("try block is being executed");
				ses.beginTransaction();
				ses.persist(user);
				ses.getTransaction().commit();		
			}
		}
		public boolean logincheck (String email,String pass) {
			try(Session ses=HBUtil.getSessionFactory().openSession()){
				String hql="from login where email=:emailid and pass=:pass";
			Login user=ses.createQuery(hql,Login.class).setParameter("emailid", email).setParameter("pass", pass).getSingleResult();
				System.out.println(user);
				return user !=null;
				
			}
		}
	
	}
