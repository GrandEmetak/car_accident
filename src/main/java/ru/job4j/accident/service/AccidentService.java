package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentMem;

import java.util.Collection;
import java.util.Objects;

/**
 * описывающий логику работы.
 * -@Service для классов с бизнес логикой
 */
@Service
public class AccidentService {

    private AccidentMem accidentMem;

    public AccidentService() {
        AccidentMem accidentMem = new AccidentMem();
        this.accidentMem = accidentMem;
    }

    /**
     * @return возвращает коллекцию значнией
     */
    public Collection<Accident> getAll() {
        return accidentMem.getAll();
    }
}
