 package com.bridgelabz.HibernateCRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;


public class CreateTableAndInsertVAlueInDB
{
	
	public static void main(String[] args) 
	{
		
		 //Create student entity object
		  Student student = new Student();
		  student.setStudentName("Shweta Dhobi");
		  student.setRollNumber(11);
		  student.setCourse("Comps");
		  
		  
		//configration is the class which extends the sessionFactory interface
	    	Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
	    	
	    	//building the serviceRegistry object.
	    	org.hibernate.service.ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
	    	
	    	SessionFactory sessionFactory= con.buildSessionFactory(registry); 
	    	
		 
		  //getting session object from session factory
		  Session session = sessionFactory.openSession();
		  //getting transaction object from session object
		  org.hibernate.Transaction tx= session.beginTransaction();
		  
		  session.save(student);
		  
		  System.out.println("Inserted Successfully");
		  
		  tx.commit();
		  
		  session.close();
		  sessionFactory.close();
		
		
	}//main end.

}//class end.
