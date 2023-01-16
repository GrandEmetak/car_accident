package com.autoviolation.repository;

import com.autoviolation.model.Accident;
import com.autoviolation.model.AccidentType;
import com.autoviolation.model.Rule;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Хранилище инцидентов
 * хранение происходит в памяти запущенного приложения
 */
@Repository
public class AccidentMem {

    private AtomicInteger count = new AtomicInteger(0);

    private Map<Integer, AccidentType> types = new HashMap<>();

    private Map<Integer, Rule> rules = new HashMap<>();

    private Map<Integer, Accident> accidents = new HashMap<>();

    public AccidentMem() {
        this.accidents.put(1, Accident.of(count.incrementAndGet(), "Petr Arsentev",
                "Превышение скорость на  60 км/ч ",
                "ул. Большая Сухаревская 11")
        );
        this.accidents.put(2, Accident.of(count.incrementAndGet(), "Ivan Sobolev",
                "Проезд на красный свет",
                "ул. Охотный ряд 115")
        );
        this.accidents.put(3, Accident.of(count.incrementAndGet(), "Fedor Semenov",
                "Превышение скорость на  35 км/ч ",
                "ул. Обводной Вал 17")
        );
        initRule();
        initTypes();
    }

    /**
     * Производит сохранение в Бд Object Accident
     *
     * @param accident Object new or update
     * @return saved Accident Object
     */
    public Accident save(Accident accident) {
        System.out.println("Объект что пришел в хранилище : " + accident);
        int id = accident.getType().getId();
        accident.getType().setName(whatType(id));
        if (accident.getId() == 0) {
            System.out.println("ТО что в поле Атомик : " + count);
            accident.setId(count.incrementAndGet());
            this.accidents.put(accident.getId(), accident);
            return accident;
        } else {
            this.accidents.put(accident.getId(), accident);
            return accident;
        }
    }

    /**
     * получение типа по выбранному id select
     *
     * @param id
     * @return
     */
    private String whatType(int id) {
        return types.get(1).getName();
    }

    /**
     * инициализирует Map<Integer, AccidentType> types
     * эмуляция БД все объектов AccidentType
     */
    private void initTypes() {
        types.put(1, AccidentType.of(1, "Две машины"));
        types.put(2, AccidentType.of(2, "Машина и человек"));
        types.put(3, AccidentType.of(3, "Машина и велосипед"));
    }

    public void put(Integer value, Accident accident) {
        accidents.put(value, accident);
    }

    /**
     * @return возвращает коллекцию значнией
     */
    public Collection<Accident> getAll() {
        return accidents.values();
    }

    public Collection<AccidentType> getAllAccidentType() {
        return types.values();
    }

    public Collection<Rule> getAllRules() {
        return rules.values();
    }

    /**
     * поиск Accident по id, id in this case is key
     */
    public Accident get(int id) {
        return accidents.get(id);
    }

    public Rule findByIdRule(int id) {
        return rules.get(id);
    }

    /**
     * статьи правонарушения
     * инициализирует Map<Integer, Rule> rules, эмуляция таблицы в БД Rule Objects
     */
    private void initRule() {
        rules.put(1, Rule.of(1, "Статья. 1"));
        rules.put(2, Rule.of(2, "Статья. 2"));
        rules.put(3, Rule.of(3, "Статья. 3"));
    }
}
