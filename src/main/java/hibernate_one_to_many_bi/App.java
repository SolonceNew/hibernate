package hibernate_one_to_many_bi;


import hibernate_one_to_many_bi.entity.Department;
import hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main( String[] args ) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
       try {

          session = factory.getCurrentSession();
          // создание департамента и 2-х работников департамента
           Department dep = new Department("Sales", 1200, 800);
           Employee employee1 = new Employee("Anna", "Fabrichnaya", 1000);
           Employee employee2 = new Employee("Nina", "Smirnova", 800);
           Employee employee3 = new Employee("Andrey", "Ivanov", 900);
           dep.addEmployeeToDepartment(employee1);
           dep.addEmployeeToDepartment(employee2);
           dep.addEmployeeToDepartment(employee3);
           session.beginTransaction();
           session.save(dep);

           //получение информации при eager
//           session = factory.getCurrentSession();
//           session.beginTransaction();
//           Department dep = session.get(Department.class, 1);
//           System.out.println(dep);
//           System.out.println(dep.getEmps());

           //получение информации о конкретном работнике
//           session = factory.getCurrentSession();
//           session.beginTransaction();
//           Employee emp = session.get(Employee.class, 1);
//           System.out.println(emp);
//           System.out.println(emp.getDepartment());
           session.getTransaction().commit();
           //чтобы при удалении работника не удалялись другие работники
           //нужно в классах энтити убрать каскад all и заменить на persist,
           //merge, refresh, detach

       } finally {
           session.close();
           factory.close();
       }

    }
}
