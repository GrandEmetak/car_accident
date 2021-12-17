package ru.job4j.accident.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.HashSet;
import java.util.Set;

/**
 * данный класс использован для наглядности работы, методов
 */
public class Temp {
    public static void main(String[] args) {
        Accident accident = new Accident("Ivan Petrov",
                "Превышение скорость на  80 км/ч ",
                "ул. Большая Сухаревская 11");

        AccidentType accidentType = new AccidentType("Машина и машина");

        Rule rule = new Rule("Статья 1", accident);
        Rule rule2 = new Rule("Статья 2", accident);

        accidentType.setAccident(accident);
        rule.setAccident(accident);
        rule2.setAccident(accident);
        accident.addRuleToAccident(rule);
        accident.addRuleToAccident(rule2);
        accident.setType(accidentType);

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        Session session = null;
        try {
            session = sf.getCurrentSession();
            session.beginTransaction();

            System.out.println("Size : " + accident.getRules().size());
            System.out.println("before save : " + accident);

            session.persist(accident);
            var acc = session.get(Accident.class, 1);

            System.out.println("after save : " + acc);

            session.getTransaction().commit();
            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}

