package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Хранилище инцидентов
 * 2. IndexControl. Таблица и вид. [#2092]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
 * 3.1. @RequestParam. Форма редактирования [#308708]01
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
 * 4. Form с композиционным объектом [#305522]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
 */
@Repository
public class AccidentMem {
    private AtomicInteger count = new AtomicInteger(0);

    private Map<Integer, Accident> accidents = new HashMap<>();

    public AccidentMem() {
        this.accidents.put(1, Accident.of(count.incrementAndGet(), "Pet Arsentev",
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
    }

    public Accident create(Accident accident) {
        System.out.println("Объект что пришел в хранилище : " + accident);
        int id  = accident.getType().getId();
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
     * @param id
     * @return
     */
    private String whatType(int id) {
        List<AccidentType> types = new ArrayList<>();
        types.add(AccidentType.of(1, "Две машины"));
        types.add(AccidentType.of(2, "Машина и человек"));
        types.add(AccidentType.of(3, "Машина и велосипед"));
        return types.get(id - 1).getName();
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

    /**
     * поиск Accident по id, id in this case is key
     */
    public Accident get(int id) {
        return accidents.get(id);
    }
}
