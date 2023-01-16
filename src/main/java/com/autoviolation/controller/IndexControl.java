package com.autoviolation.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.autoviolation.repository.AccidentHibernate;

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
