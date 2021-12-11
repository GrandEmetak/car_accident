package ru.job4j.accident.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Модель данных - правонарушения.
 * 2. IndexControl. Таблица и вид. [#2092 #235642]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
 */
public class Accident {
    private int id;
    private String name;
    private String text;
    private String address;

    private AccidentType type;

    public static Accident of(int id, String name, String text, String address) {
        Accident accident = new Accident();
        accident.id = id;
        accident.name = name;
        accident.text = text;
        accident.address = address;
        return accident;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public AccidentType getType() {
        return type;
    }

    public void setType(AccidentType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Accident accident = (Accident) o;
        return id == accident.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("Accident: id=%s, name=%s, text=%s, address=%s, AccidentType=%s",
                id, name, text, address, type);
    }
}
