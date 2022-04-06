package hibernate_one_to_many_uni;



import hibernate_one_to_many_uni.entity.Department;
import hibernate_one_to_many_uni.entity.Employee;
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

//          session = factory.getCurrentSession();
//          Department dep = new Department("HR", 1500, 500);
//          Employee employee1 = new Employee("Oleg", "Ivanov", 700);
//          Employee employee2 = new Employee("Andrey", "Sidorov", 900);
//          dep.addEmployeeToDepartment(employee1);
//          dep.addEmployeeToDepartment(employee2);
//          session.beginTransaction();
//          session.save(dep);

           //получение всех работников департамента
//           session = factory.getCurrentSession();
//           session.beginTransaction();
//           Department dep = session.get(Department.class, 3);
//           System.out.println(dep);
//           System.out.println(dep.getEmps());

           //получение информации о конкретном работнике
          // session = factory.getCurrentSession();
           //session.beginTransaction();
           //Employee emp = session.get(Employee.class, 1);
           //System.out.println(emp);

           // удаление работника
//           session = factory.getCurrentSession();
//           session.beginTransaction();
//           Employee employee = session.get(Employee.class, 1);
//           session.delete(employee);
           session = factory.getCurrentSession();
           session.beginTransaction();
           Department department = session.get(Department.class, 3);
           session.delete(department);
           Department department2 = session.get(Department.class, 4);
           session.delete(department2);
           session.getTransaction().commit();


       } finally {
           session.close();
           factory.close();
       }

    }
}
