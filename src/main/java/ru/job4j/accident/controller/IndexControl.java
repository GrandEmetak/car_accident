package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.accident.repository.AccidentJdbcTemplate;
import ru.job4j.accident.repository.AccidentMem;
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
 */
@Controller
public class IndexControl {
    private final AccidentJdbcTemplate accidents;

    public IndexControl(AccidentJdbcTemplate accidents) {
        this.accidents = accidents;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("accidents", accidents.getAll());
        return "index";
    }
}
