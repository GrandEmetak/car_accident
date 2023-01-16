package com.autoviolation.repository;

import com.autoviolation.model.Accident;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * В этот класс мы передаем объект SessionFactory.
 */
@Repository
public class AccidentHibernate {
    private final SessionFactory sf;

    public AccidentHibernate(SessionFactory sf) {
        this.sf = sf;
    }

    /**
     * сохранение Accident object in to DB
     *
     * @param accident Object
     * @return saved in to db Accident object
     * - session.save(accident);
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
     * @return List<Accident>
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
