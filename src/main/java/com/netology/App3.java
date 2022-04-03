package com.netology;

import com.netology.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App3 {
    public static void main( String[] args ) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {

            Session session = factory.getCurrentSession();
            session.beginTransaction();
            // обновляем имя и фамилию
            // Employee emp = session.get(Employee.class, 4);
            //emp.setName("Oleg");
            //emp.setSurname("Kravzov");

            //обновляем зарплату у нескольих сотрудников c одним именем
            session.createQuery("update Employee set salary=1000" +
                    "where name='Alex'").executeUpdate();
            session.getTransaction().commit();

        } finally {
            factory.close();
        }

    }
}
