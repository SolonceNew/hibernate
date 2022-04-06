package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main( String[] args ) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;
       try {

           session = factory.getCurrentSession();
           Employee emp = new Employee("Anna", "Fabrichnaya", "IT", 500);
//           Detail detail = new Detail("Moscow", "678-278", "fabrichnaya@mail.ru");
//           emp.setEmpDetail(detail);
//           session.beginTransaction();
//           session.save(emp);
//           session.getTransaction().commit();
//           session.beginTransaction();
//           Employee emp = session.get(Employee.class, 1);
//           session.delete(emp);
           session.getTransaction().commit();
       } finally {
           factory.close();
           session.close();
       }

    }
}
