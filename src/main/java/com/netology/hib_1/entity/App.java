package com.netology.hib_1.entity;

import com.netology.hib_1.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App
{
    public static void main( String[] args ) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

       try {

           Session session = factory.getCurrentSession();
           Employee emp = new Employee("Alex", "Kuv", "IT", 600);
           session.beginTransaction();
           session.save(emp); // сохранили объект в базу данных
           session.getTransaction().commit(); // закрываем транзакцию
       } finally {
           factory.close();
       }

    }
}
