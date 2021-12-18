package ru.job4j.accident.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * Пользователь
 * 2. Регистрация пользователя [#296069]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.4. Security
 * Добавим модели данных и репозитории для новых моделей.
 * + Authority class
 * + Репозиторий interface AuthorityRepository
 * + Репозиторий interface UserRepository
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String password;

    private String username;

    @ManyToOne
    @JoinColumn(name = "authority_id")
    private Authority authority;

    private boolean enabled;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{"
                + "id=" + id
                + ", password='" + password + '\''
                + ", username='" + username + '\''
                + ", enabled=" + enabled
                + '}';
    }
}
