package com.web;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionImpl;


import java.util.Date;
import java.util.List;

/**
 * Created by Alex Yang on 2016/12/15.
 */
public class Main {



   public static void main(String[] args) {

      Configuration cfg = new Configuration();
      cfg.configure();
      SessionFactory sf = cfg.buildSessionFactory();
      Session s = sf.openSession();
      Transaction tx = s.beginTransaction();
      List result = s.createQuery("From User").list();
      for ( User event : (List<User>) result ) {
         System.out.println( "Event (" + event.getName() + ") : " + event.getBirthday() );
      }
      //User use = new User();
      //use.setBirthday(new Date());
      //use.setName("TT");
      //s.save(use);
      //User u= s.load(User.class, new Integer(2));
      //System.out.print(u.getBirthday());
      //Customer c = new Customer();
      //c.setBirthday(new Date());
      //c.setName("customer");
      //c.setId(1);
      //s.delete(c);
      //Serializable id;
      //s.save(c);
      //System.out.print(id);
      tx.commit();
      s.close();
      sf.close();


   }

}
