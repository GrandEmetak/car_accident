package ru.job4j.accident.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.accident.model.User;

/**
 * Repository
 * 2. Регистрация пользователя [#296069]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.4. Security
 * Добавим модели данных и репозитории для новых моделей.
 * + Authority class
 * + Репозиторий interface AuthorityRepository
 * + User class
 */
public interface UserRepository extends CrudRepository<User, Integer> {
}
