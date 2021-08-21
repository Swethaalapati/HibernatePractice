package com.hibernate.GetAndLoad;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
        Laptop laptop = new Laptop(1,"Lenovo", 40000);
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Laptop.class);
        
        StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties());
        SessionFactory factory = con.buildSessionFactory(reg.build());
        
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(laptop);
        
        laptop.setBrand("Hp");
        
        tx.commit();
        
        laptop.setBrand("Dell");
        
        session.close();
        
        session = factory.openSession();
        
        tx = session.beginTransaction();
        
        Laptop laptop1 = (Laptop) session.get(Laptop.class, 1);
        
        System.out.println(laptop1);
        
        Laptop laptop2 = (Laptop) session.load(Laptop.class, 1);
                        
        System.out.println(laptop2);
        
        tx.commit();
        session.close();
        
    }
}
