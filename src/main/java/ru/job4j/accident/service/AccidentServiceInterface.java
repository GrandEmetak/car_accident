package ru.job4j.accident.service;

import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.Rule;

import java.util.Collection;
import java.util.Set;

/**
 * Интерфейс описывающий логику работыт с СервисОбъектом
 * 4. Form с композиционным объектом [#305522]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
 * 5. Form с аргегационными объектами [#305523]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
 */
public interface AccidentServiceInterface {

    public Accident create(Accident accident);

    public Collection<Accident> getAll();

    public Accident findById(int id);

    public Rule servFindByIdRule(int id);

    public Accident putRuleToAccid(Accident accident, String[] iDs);

}
