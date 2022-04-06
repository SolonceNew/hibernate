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

           session.beginTransaction();
           //удаляем только детали о работнике из таблицы
           Detail detail = session.get(Detail.class, 3);
           //разрушаем связь между эплои и деталями
           detail.getEmployee().setEmpDetail(null);
           session.delete(detail);
           session.getTransaction().commit();
       } finally {
           session.close();
           factory.close();
       }

    }
}
