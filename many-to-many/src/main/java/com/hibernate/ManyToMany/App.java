package com.hibernate.ManyToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
    	List<LaptopMm> laptop = new ArrayList<LaptopMm>();
    	List<StudentMm> student = new ArrayList<StudentMm>();
    	
    	StudentMm student1 = new StudentMm(1, "Swetha", "CSE", null);
    	StudentMm student2 = new StudentMm(2, "Swathi", "IT", null);
    	
    	student.add(student1);
    	student.add(student2);
    	LaptopMm lap1 = new LaptopMm(101, "Lenovo", null);
    	LaptopMm lap2 = new LaptopMm(102, "Dell", null);
    	
    	laptop.add(lap2);
    	laptop.add(lap1);
    	
    	student1.setLaptop(laptop);
    	student2.setLaptop(laptop);
    	
    	lap1.setStudent(student);
    	lap2.setStudent(student);
    	    	    	
        Configuration con = new Configuration().configure().addAnnotatedClass(StudentMm.class).addAnnotatedClass(LaptopMm.class);
        
        StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties());
        
        SessionFactory sf = con.buildSessionFactory(reg.build());
        
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(student1);
        
        session.save(lap1);
        
        
        tx.commit();
        
        session.close();
        
                
        Session session1 = sf.openSession();
        
        Transaction tx1 = session1.beginTransaction();
        
        session1.save(student2);
        session1.save(lap2);
        
        tx1.commit();
        
        session1.close();
        
    }
}
