package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.repository.AccidentRepository;

/**
 * 2. Spring Data [#296073 #241197]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.3. Template, ORM
 */
@Service
public class AccidentRepositoryService {

    private AccidentRepository accidentRepository;

    public AccidentRepositoryService(AccidentRepository accidentRepository) {
        this.accidentRepository = accidentRepository;
    }

    public AccidentRepository getAccidentRepository() {
        return accidentRepository;
    }

    public void setAccidentRepository(AccidentRepository accidentRepository) {
        this.accidentRepository = accidentRepository;
    }
}
