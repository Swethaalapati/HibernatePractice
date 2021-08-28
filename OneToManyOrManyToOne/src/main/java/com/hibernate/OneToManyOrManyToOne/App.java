package com.hibernate.OneToManyOrManyToOne;

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
    	List<LaptopOm> laptop = new ArrayList<LaptopOm>();
    	
    	StudentOm student = new StudentOm(1, "Swetha", "CSE", laptop);
    	LaptopOm lap1 = new LaptopOm(101, "Lenovo", student);
    	
    	laptop.add(lap1);
    	    	    	
        Configuration con = new Configuration().configure().addAnnotatedClass(StudentOm.class).addAnnotatedClass(LaptopOm.class);
        
        StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties());
        
        SessionFactory sf = con.buildSessionFactory(reg.build());
        
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(student);
        session.save(lap1);
        
        
        tx.commit();
    }
}
