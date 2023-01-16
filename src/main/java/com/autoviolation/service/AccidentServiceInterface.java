package com.autoviolation.service;

import com.autoviolation.model.Accident;
import com.autoviolation.model.Rule;

import java.util.Collection;

/**
 * Интерфейс описывающий логику работыт с СервисОбъектом
 * 4. Form с композиционным объектом [#305522]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
 * 5. Form с аргегационными объектами [#305523]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
 */
public interface AccidentServiceInterface {

    public Accident save(Accident accident);

    public Collection<Accident> getAll();

    public Accident findById(int id);

    public Rule servFindByIdRule(int id);

    public Accident putRuleToAccid(Accident accident, String[] iDs);

}
