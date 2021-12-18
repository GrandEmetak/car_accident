package ru.job4j.accident.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * 2. Регистрация пользователя [#296069]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.4. Security
 * Добавим модели данных и репозитории для новых моделей.
 */
@Entity
@Table(name = "authorities")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String authority;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Authority authority = (Authority) o;
        return id == authority.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Authority{"
                + "id=" + id
                + ", authority='" + authority + '\''
                + '}';
    }
}
