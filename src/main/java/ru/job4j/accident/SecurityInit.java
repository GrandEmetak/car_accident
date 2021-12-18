package ru.job4j.accident;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Подключение фильтров происходит за счет добавления класса -
 * Он подключает DelegatingFilterProxy. Это главный фильтр, в котором идет обработка запросов.
 * Tomcat автоматически определяет такой класс и подключает эти фильтры.
 * 0. Spring Security [#6879]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.4. Security
 */
public class SecurityInit extends AbstractSecurityWebApplicationInitializer {

}
