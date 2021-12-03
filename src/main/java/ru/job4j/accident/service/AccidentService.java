package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.repository.AccidentMem;

import java.util.Objects;

/**
 * описывающий логику работы.
 * -@Service для классов с бизнес логикой
 */
@Service
public class AccidentService {

    private AccidentMem accidentMem;

    public AccidentService(AccidentMem accidentMem) {
        this.accidentMem = accidentMem;
    }

    public AccidentMem getAccidentMem() {
        return accidentMem;
    }

    public void setAccidentMem(AccidentMem accidentMem) {
        this.accidentMem = accidentMem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccidentService that = (AccidentService) o;
        return Objects.equals(accidentMem, that.accidentMem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accidentMem);
    }

    @Override
    public String toString() {
        return "AccidentService{"
                + "accidentMem="
                + accidentMem
                + '}';
    }
}
