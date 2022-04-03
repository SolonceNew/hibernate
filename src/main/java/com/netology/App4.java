package com.netology;

import com.netology.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App4 {
         public static void main( String[] args ) {
            SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Employee.class)
                    .buildSessionFactory();

            try {

                Session session = factory.getCurrentSession();
                session.beginTransaction();
                //удаление если ест данные о сотруднике
                //Employee emp = session.get(Employee.class, 7);
                //session.delete(emp);

                //удаляем Алексов
                session.createQuery("delete Employee where name='Alex'").executeUpdate();

                session.getTransaction().commit();

            } finally {
                factory.close();
            }

        }
}
