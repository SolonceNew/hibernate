package hibernate_many_to_many;



import hibernate_many_to_many.entity.Child;
import hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;

public class App {
    public static void main( String[] args ) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;
       try {

//          session = factory.getCurrentSession();
//          Section section1 = new Section("Football");
//          Child child = new Child("Zaur", 5);
//          Child child2 = new Child("Masha", 7);
//          Child child3 = new Child("Vasya", 6);
//          section1.addChildToSection(child);
//           section1.addChildToSection(child2);
//           section1.addChildToSection(child3);
//          session.beginTransaction();
//          session.save(section1);
//          session.getTransaction().commit();

//           session = factory.getCurrentSession();
//           Section section1 = new Section("Voleyball");
//           Section section2 = new Section("Chess");
//           Section section3 = new Section("Math");
//           Child child = new Child("Igor", 10);
//
//           child.addSectionToChild(section1);
//           child.addSectionToChild(section2);
//           child.addSectionToChild(section3);
//           session.beginTransaction();
//           session.save(child);
//           session.getTransaction().commit();

          //получаем информацию о секции и о детях в ней
//           session = factory.getCurrentSession();
//           session.beginTransaction();
//           Section section = session.get(Section.class, 1);
//           System.out.println(section);
//           System.out.println(section.getChildren());
//          session.getTransaction().commit();

//           получаем информацию по ребенку
//           session = factory.getCurrentSession();
//           session.beginTransaction();
//           Child child = session.get(Child.class, 3);
//           System.out.println(child);
//           System.out.println(child.getSections());
//           session.getTransaction().commit();

           //если удлить секцию, то удалятся и дети, которые ее посещают,
           //чтобы этого не было нужно удалить в стратегии remove
//           session = factory.getCurrentSession();
//           session.beginTransaction();
//           Section section = session.get(Section.class, 1);
//           session.delete(section);
//           session.getTransaction().commit();

           // Если каскейт не all, то каскадное сохранение не работает,
           // для того, чтобы сохранять нужен метод не save а persist

//           session = factory.getCurrentSession();
//           Section section = new Section("Dance");
//           Child child1 = new Child("Olesya", 9);
//           Child child2 = new Child("Katya", 6);
//           Child child = new Child("Ben", 8);
//           section.addChildToSection(child);
//           section.addChildToSection(child1);
//           section.addChildToSection(child2);
//           session.beginTransaction();
//           session.persist(section);
//           session.getTransaction().commit();

           //удаляем секцию танцев, поскольку каскадного удаления нет,
           // то дети из секции не удалятся
//           session = factory.getCurrentSession();
//
//           session.beginTransaction();
//           Section section = session.get(Section.class, 7);
//           session.delete(section);
//           session.getTransaction().commit();

           //удаляем ребенка
           session = factory.getCurrentSession();

           session.beginTransaction();
           Child child = session.get(Child.class, 4);
           session.delete(child);
           session.getTransaction().commit();

       } finally {
           session.close();
           factory.close();
       }

    }
}
