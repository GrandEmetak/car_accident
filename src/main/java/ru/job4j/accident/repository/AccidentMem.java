package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Хранилище инцидентов
 * 2. IndexControl. Таблица и вид. [#2092]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
 * 3.1. @RequestParam. Форма редактирования [#308708]01
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
 */
@Repository
public class AccidentMem {

    private Map<Integer, Accident> accidents = new HashMap<>();

    public AccidentMem() {
        this.accidents.put(1, Accident.of(1, "Pet Arsentev",
                "Превышение скорость на  60 км/ч ",
                "ул. Большая Сухаревская 11")
        );
        this.accidents.put(2, Accident.of(2, "Ivan Sobolev",
                "Проезд на красный свет",
                "ул. Охотный ряд 115")
        );
        this.accidents.put(3, Accident.of(3, "Fedor Semenov",
                "Превышение скорость на  35 км/ч ",
                "ул. Обводной Вал 17")
        );
    }

    public void create(Accident accident) {
        System.out.println("Объект что пришел в хранилище : " + accident);
        int s = accidents.size();
        System.out.println("Size Map accident : " + accidents.size());
        if (accident.getId() == 0) {
            accident.setId(s + 1);
            this.accidents.put(accident.getId(), accident);
        } else {
            this.accidents.put(accident.getId(), accident);
        }
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
    public Accident findById(int id) {
        return accidents.get(id);
    }
}
