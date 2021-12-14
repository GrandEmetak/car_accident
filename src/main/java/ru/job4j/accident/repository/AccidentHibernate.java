package ru.job4j.accident.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.List;

/**
 * 1. Spring ORM [#2093]
 * Уровень : 3. Мидл Категория : 3.4. SpringТопик : 3.4.3. Template, ORM
 * В этот класс мы передаем объект SessionFactory.
 * Spring помог связать SessionFactory с AccidentHibernate.
 * Это все, что здесь сделал Spring.
 *
 *
 */
@Repository
public class AccidentHibernate {
    private final SessionFactory sf;

    public AccidentHibernate(SessionFactory sf) {
        this.sf = sf;
    }

    public Accident save(Accident accident) {
        try (Session session = sf.openSession()) {
            session.save(accident);
            return accident;
        }
    }

    public List<Accident> getAll() {
        try (Session session = sf.openSession()) {
            return session
//                    .createQuery("from Accident", Accident.class)
                    .createQuery("select distinct st from Accident st "
                                    + "join fetch st.rules a, "
                                    + "join fetch st.accident_types b", /* ошибка */
                            Accident.class)
                    .list();
        }
    }
}
