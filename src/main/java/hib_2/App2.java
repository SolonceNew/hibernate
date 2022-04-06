package hib_2;

import hib_2.entity.Detail;
import hib_2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App2 {
    public static void main( String[] args ) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;
       try {

           session = factory.getCurrentSession();
           Employee emp = new Employee("Nik", "Ivanov", "HR", 850);
           Detail detail = new Detail("NY", "789-878", "Nik@mail.ru");
           emp.setEmpDetail(detail);
           detail.setEmployee(emp);
           session.beginTransaction();
           session.save(detail);

           session.getTransaction().commit();
       } finally {
           factory.close();
           session.close();
       }

    }
}
