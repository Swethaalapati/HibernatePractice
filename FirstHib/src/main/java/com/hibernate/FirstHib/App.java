package com.hibernate.FirstHib;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;



public class App 
{
    public static void main( String[] args )
    {
        Employee employee = new Employee();
        employee.setId(11);
        employee.setName("Chintu");
        employee.setRole("Developer");
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class);
        
        StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties());
        
        SessionFactory sf = con.buildSessionFactory(reg.build());
        
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(employee);
        
        tx.commit();
        

    }
}
