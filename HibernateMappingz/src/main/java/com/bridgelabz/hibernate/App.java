package com.bridgelabz.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Laptop l = new Laptop();
    	l.setLid(101);
    	l.setLname("Dell");
      
    	Student s = new Student();
    	s.setRollno(7);    	
    	s.setName("supriya");
    	s.setMarks(84);
    	//s.setLaptop(l);
    	s.getLaptops().add(l);

    	//configration is the class which extends the sessionFactory interface
    	Configuration con = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
    	
    	//building the serviceRegistry object.
    	org.hibernate.service.ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    	
    	SessionFactory sessionFactory= con.buildSessionFactory(registry); 
    	
    	//session and sessionFactory is the interface so create object of class which extends this interface.
    	//SessionFactory sf= con.buildSessionFactory(); 
    	/*method is striked as it is a deprecated method.
		    	i.e ---> Similarly, when a class or method is deprecated, it means that the class or 
		    	method is no longer considered important. It is so unimportant, in fact, 
		    	that it should no longer be used at all, as it might well cease to exist in the future.*/
		    	
    	//for session interface add the maven dependencies first.	
    	Session session = sessionFactory.openSession(); //for building session object create object of sessionFactory first. 
    			
    	//start the transaction
    	org.hibernate.Transaction tx = session.beginTransaction();
    	
    		
    	//persist (store) the data into the DB.
    	session.save(l);
    	session.save(s);//save method belongs to session interface. so add session first...
    	
    	//commit the transaction
    	tx.commit();
    	
    	/*now storing this data into the DB.
    	* 
    	* 1-- from eclipse market tools install the JBoss tools to get the required plugins for hibernate.
    	* 2-- connect to hibernate dillect, by selecting hibernate.cfg.xml file. keep version of hibernate as 4.3
    	* 3-- then we get the hibernate.cfg.xml file directly.
    	* 4-- connect  that cfg.xml file by writing configure() so that the cfg.xml file is used by app.java class
    	*           i.e -->Configuration con = new Configuration().configure(); 
    	*           if the file name of cfg.xml is other than 
    	*           hibernate.cfg.xml like hib.cfg.xml then specify in configure() 
    	*           i.e -->Configuration con = new Configuration().configure(" hib.cfg.xml");
    	*           
    	*  5-- allow the class Person to store its object into DB so write annotation @Entity above
    	*       the person class which is present inside the package entity- javax.persistence.Entity.          
    	*  6-- add annotated class after configure() to specify with which class we are workin with.; 
    	*       i.e --> Configuration con = new Configuration().configure().addAnnotatedClass(Person.class);       
    	*  7-- Every table in hibernate should have a primary key so set primary key inside person class
    	*      by  annotation @Id which is of package  javax.persistence.Id;     
    	*  8-- Whenever you want to make changes in database follow the ACID properties so create an object
    	*      of Transaction and begin transaction,i.e->Transaction tx = (Transaction) session.beginTransaction();
    	*      
    	*  9-- lastly commit the transaction  by tx.commit(); and throws clause of
    	*   	RollbackException, HeuristicMixedException, HeuristicRollbackException will be added.          
    	*  10-- ask hibernate for creating the table by specifing inside the 
    	*  				cfg file to create the table for mi inside the DB by writing 
    	*      -->  <property name="hbm2ddl.auto">update</property>.         
    	*   11- table is created in DB of name Person  and coloumnd id name and dept.
    	*   
    	*  12- we can remove the deprecated method by building serviceRegistry object      
    	*        i.e -->org.hibernate.service.ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    	*				SessionFactory sf= con.buildSessionFactory(registry); 
    	*
    	*/
    }
    
    
}
