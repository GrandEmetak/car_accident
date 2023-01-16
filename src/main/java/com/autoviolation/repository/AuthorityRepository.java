package com.autoviolation.repository;

import com.autoviolation.model.Authority;
import org.springframework.data.repository.CrudRepository;

/**
 * Репозиторий.
 * 2. Регистрация пользователя [#296069]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.4. Security
 * Добавим модели данных и репозитории для новых моделей.
 * + Authority class
 */
public interface AuthorityRepository extends CrudRepository<Authority, Integer> {
    Authority findByAuthority(String authority);
}
