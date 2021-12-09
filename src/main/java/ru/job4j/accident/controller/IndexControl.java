package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.accident.repository.AccidentMem;
import ru.job4j.accident.service.AccidentService;

import java.util.ArrayList;
import java.util.List;

/**
 * контроллер для главной страницы
 * -@Controller для обработчиков запросов.
 */
@Controller
public class IndexControl {

    private AccidentService accidentService;

    public IndexControl(AccidentMem accidentMem) {

        this.accidentService = new AccidentService(accidentMem);
    }

    public AccidentService getAccidentService() {
        return accidentService;
    }

    @GetMapping("/")
    public String index(Model model) {
        var acc = getAccidentService();
        model.addAttribute("accidents", accidentService.getAll());
        return "index";
    }
}
