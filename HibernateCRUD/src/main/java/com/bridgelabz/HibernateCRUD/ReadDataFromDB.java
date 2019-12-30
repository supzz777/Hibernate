package com.bridgelabz.HibernateCRUD;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class ReadDataFromDB 
{
//	 public  static Logger logger  ;
	 public static Logger logger = Logger.getAnonymousLogger();
	 
	 @SuppressWarnings("unchecked")
	    public static List displayRecords() 
	 {	//configration is the class which extends the sessionFactory interface
	    	Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
	    	
	    	//building the serviceRegistry object.
	    	org.hibernate.service.ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
	    	
	    	SessionFactory sessionFactory= con.buildSessionFactory(registry); 
	    	Session session = null;
	        List studentsList = new ArrayList();        
	        try {
	            // Getting Session Object From SessionFactory
	            session = sessionFactory.openSession();
	            // Getting Transaction Object From Session Object
	            session.beginTransaction();
	 
	            studentsList = session.createQuery("FROM Student").list();
	        } catch(Exception sqlException) {
	            if(null != session.getTransaction()) {
	                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
	                session.getTransaction().rollback();
	            }
	            sqlException.printStackTrace();
	        } finally {
	            if(session != null) {
	                session.close();
	            }
	        }
	        return studentsList;
	    }
	 
	 
	public static void main(String[] args) 
	 {
		
		 ReadDataFromDB r = new  ReadDataFromDB();
		
		
		 logger.info("\n=======READ RECORDS=======\n");
		 
	        List viewStudents = r.displayRecords();
	        
	        Iterator<Student> it=viewStudents.iterator();
	        if(viewStudents != null & viewStudents.size() > 0)
	        {
	            while(it.hasNext())
	            {
	                logger.info(it.next().toString());
	            }
	        }
		/*
		  
			//configration is the class which extends the sessionFactory interface
		    	Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
		    	
		    	//building the serviceRegistry object.
		    	org.hibernate.service.ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		    	
		    	SessionFactory sessionFactory= con.buildSessionFactory(registry); 
			    	
			  //getting session object from session factory
			  Session session = sessionFactory.openSession();
			  //getting transaction object from session object
			  session.beginTransaction();
			  Query query = session.createQuery("from Student");
			  List students = query.list();
			  for(Student student : students)
			  {
			System.out.println("Roll Number: "+student.getRollNumber()+", Student Name: "+student.getStudentName()+", Course: "+student.getCourse());
			  }
			  session.getTransaction().commit();
			  sessionFactory.close();
			  
		
		    	
		    */
		    	
		    	
		    	
	 }

}
