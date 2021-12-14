package ru.job4j.accident.repository;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.HashSet;
import java.util.Set;

public class Temp {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            AccidentHibernate accidentHibernate = new AccidentHibernate(sf);

            Accident accident = new Accident();
            accident.setName("Petr Arsentev");
            accident.setText("Превышение скорость на  60 км/ч ");
            accident.setAddress("ул. Большая Сухаревская 11");
            AccidentType accidentType = new AccidentType("Машина и велосипед", accident);
            accident.setType(accidentType);
            Rule rule = new Rule("Статья 1", accident);
            Rule rule2 = new Rule("Статья 2", accident);
            accident.getRules().add(rule);
            accident.getRules().add(rule2);

            System.out.println("Size : " + accident.getRules().size());
            System.out.println("before save : " + accident);
            var acc = accidentHibernate.save(accident);
            System.out.println("after save : " + acc);
            var rsl = accidentHibernate.getAll();
            rsl.stream().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}

