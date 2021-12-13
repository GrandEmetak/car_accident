package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentMem;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * описывающий логику работы.
 * -@Service для классов с бизнес логикой
 * 2. IndexControl. Таблица и вид. [#2092 #235642]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
 * 4. Form с композиционным объектом [#305522]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
 * 5. Form с аргегационными объектами [#305523]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
 */
@Service
public class AccidentService implements AccidentServiceInterface {

    private AccidentMem accidentMem;

    public AccidentService(AccidentMem accidentMem) {
        this.accidentMem = accidentMem;
    }

    /**
     * производит запись new Accident в Репозиторий или обновление существующией записи
     *
     * @param accident Object
     * @return Accident Object
     */
    @Override
    public Accident create(Accident accident) {
        return accidentMem.create(accident);
    }

    /**
     * @return возвращает коллекцию значнией
     */
    @Override
    public Collection<Accident> getAll() {
        return accidentMem.getAll();
    }

    /**
     * @return Collection<AccidentType>
     */
    public Collection<AccidentType> getAllAccidentType() {
        return accidentMem.getAllAccidentType();
    }

    /**
     * @return Collection<Rule>
     */
    public Collection<Rule> getAllRules() {
        return accidentMem.getAllRules();
    }

    /**
     * поиск Accident по id, id in this case is key
     */
    @Override
    public Accident findById(int id) {
        return accidentMem.get(id);
    }

    /**
     * поиск одного объекта Rule о id in Repository
     *
     * @param id Rule Object
     * @return Rule object
     */
    public Rule servFindByIdRule(int id) {
        return accidentMem.findByIdRule(id);
    }

    /**
     * find Rule objet.
     *
     * @param iDs String [] idRule
     * @return Set<Rule>
     */
    private Set<Rule> findRuleArr(String[] iDs) {
        Set<Rule> ruleSet = new HashSet<>();
        for (int i = 0; i < iDs.length; i++) {
            ruleSet.add(accidentMem.findByIdRule(Integer.parseInt(iDs[i])));
        }
        return ruleSet;
    }

    /**
     * Put Rule Object
     * in to Accident Object HttpServletRequest request.getParameterValues("rIds");
     * front - create.jsp
     * @param accident Object
     * @param iDs String []
      * @return
     */
    public Accident putRuleToAccid(Accident accident, String[] iDs) {
        var ruleSet = findRuleArr(iDs);
        accident.setRules(ruleSet);
        return accident;
    }
}
