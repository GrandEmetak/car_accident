package ru.job4j.accident.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentHibernate;
import ru.job4j.accident.repository.AccidentRepository;
import ru.job4j.accident.service.AccidentRepositoryService;
import ru.job4j.accident.service.AccidentService;

import java.util.ArrayList;
import java.util.List;

/**
 * контроллер для главной страницы
 * -@Controller для обработчиков запросов.
 * 2. IndexControl. Таблица и вид. [#2092 #235642]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
 * как выгледел ранее класс class IndexControl смотреть на git
 * переходим на работу с JDBC SPRING
 * 0. Spring DataSource [#6878]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.3. Template, ORM
 * 1. Spring ORM [#2093]
 * Уровень : 3. Мидл Категория : 3.4. SpringТопик : 3.4.3. Template, ORM
 * 2. Spring Data [#296073]01
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.3. Template, ORM
 * Поправим настройку констроллера.
 * было - private final AccidentJdbcTemplate accidents;
 * public IndexControl(AccidentJdbcTemplate accidents) {
 * this.accidents = accidents;
 * }
 * заменено на - private final AccidentHibernate accidents;
 * public IndexControl(AccidentHibernate accidents){
 * this.accidents=accidents;
 * }
 * - @GetMapping("/")
 * public String index(Model model) {
 * model.addAttribute("accidents", accidents.getAll());
 * return "index";
 * }
 * позднее заменено на
 * private final AccidentRepository accidents; *
 * public IndexControl(AccidentRepository accidents) {
 * this.accidents = accidents;
 * }
 * -@GetMapping("/")
 * public String index(Model model) {
 * List<Accident> res = new ArrayList<>();
 * accidents.findAll().forEach(res::add);
 * res.stream().forEach(System.out::println);
 * model.addAttribute("accidents", res);
 * return "index";
 * }
 * + в конструктор котроллера нельзя класс передавать при данной аннотации, надо интерфейс.
 * 1. Авторизация через JDBC [#2094]00
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.4. Security
 * Добавим вывод авторизованного пользователя на индексной странице.
 * + заменим
 * private final AccidentRepository accidents;
 * public IndexControl(AccidentRepository accidents) {
 * this.accidents = accidents;
 * }
 * -@GetMapping("/")
 * public String index(Model model) {
 * List<Accident> res = new ArrayList<>();
 * accidents.findAll().forEach(res::add);
 * res.stream().forEach(System.out::println);
 * model.addAttribute("accidents", res);
 * return "index";
 * }
 */
@Controller
public class IndexControl {

    private final AccidentHibernate accidents;

    public IndexControl(AccidentHibernate accidents) {
        this.accidents = accidents;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("user", SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal());
        model.addAttribute("accidents", accidents.getAll());
        return "index";
    }
}
