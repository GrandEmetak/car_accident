package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentMem;

import java.util.Collection;
import java.util.Objects;

/**
 * описывающий логику работы.
 * -@Service для классов с бизнес логикой
 * 2. IndexControl. Таблица и вид. [#2092 #235642]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
 */
@Service
public class AccidentService {

    private AccidentMem accidentMem;

    public AccidentService(AccidentMem accidentMem) {
        this.accidentMem = accidentMem;
    }

   /* public AccidentService() {
        AccidentMem accidentMem = new AccidentMem();
        this.accidentMem = accidentMem;
    }*/

    /**
     * @return возвращает коллекцию значнией
     */
    public Collection<Accident> getAll() {
        return accidentMem.getAll();
    }
}
