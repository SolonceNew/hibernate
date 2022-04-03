package com.netology;

import com.netology.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App2 {
    public static void main( String[] args ) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {

            Session session = factory.getCurrentSession();
            session.beginTransaction();
            //получим всех работников и выведем на экран
          //  List<Employee> emps = session.createQuery("from Employee")
          //          .getResultList();
          //  for (Employee employee : emps) {
          //      System.out.println(employee);
          //  }

            //получим работника по имени
           // List<Employee> emps = session.createQuery("from Employee " +
           //                 "where name = 'Alex'").getResultList();

           // for(Employee employee : emps)
           //     System.out.println(employee);
           // session.getTransaction().commit();

            //получим работников по имени, которые зарабатывают более 100

            List<Employee> emps = session.createQuery("from Employee " +
                    "where name = 'Alex'" +
                    "AND salary > 100").getResultList();
            for(Employee employee : emps)
                System.out.println(employee);
            session.getTransaction().commit();

        } finally {
            factory.close();
        }

    }
}
