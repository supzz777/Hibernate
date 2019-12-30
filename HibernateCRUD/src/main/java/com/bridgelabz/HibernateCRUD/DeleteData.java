package com.bridgelabz.HibernateCRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class DeleteData 
{
	
	 public static void main(String[] args) 
	 {
		 
		 
		  
			//configration is the class which extends the sessionFactory interface
		    	Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
		    	
		    	//building the serviceRegistry object.
		    	org.hibernate.service.ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		    	
		    	SessionFactory sessionFactory= con.buildSessionFactory(registry); 
		    	
			  //getting session object from session factory
			  Session session = sessionFactory.openSession();
			  
			  //getting transaction object from session object
			  session.beginTransaction();
			  
			  Student student = (Student)session.load(Student.class, 4);
			  
			  session.delete(student);
			  System.out.println("Deleted Successfully");
			  session.getTransaction().commit();
			     sessionFactory.close();
			     
			     
	 }
	

}
