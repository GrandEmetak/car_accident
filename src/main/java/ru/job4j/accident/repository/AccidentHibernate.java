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
 */
@Repository
public class AccidentHibernate {
    private final SessionFactory sf;

    public AccidentHibernate(SessionFactory sf) {
        this.sf = sf;
    }

    /**
     * сохранение Accident object in to DB
     * @param accident Object
     * @return saved in to db Accident object
     *  - session.save(accident);
     */
    public Accident save(Accident accident) {
        try (Session session = sf.openSession()) {
            session.persist(accident);
            return accident;
        }
    }

    /**
     * .createQuery("from Accident", Accident.class)
     *
     * @return + "join fetch st.accident_types b", - ошибка
     */
    public List<Accident> getAll() {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("SELECT a FROM Accident a",
                            Accident.class)
                    .getResultList();
        }
    }
}
