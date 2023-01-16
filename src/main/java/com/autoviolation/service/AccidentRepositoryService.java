package com.autoviolation.service;

import org.springframework.stereotype.Service;
import com.autoviolation.repository.AccidentRepository;

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
