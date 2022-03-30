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
