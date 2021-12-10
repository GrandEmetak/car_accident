package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentMem;

/**
 3. @ModelAttribute. Создание инцидента. [#261013]
 Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
 */
@Controller
public class AccidentControl {
    private final AccidentMem accidents;

    public AccidentControl(AccidentMem accidents) {
        this.accidents = accidents;
    }

    @GetMapping("/create")
    public String create() {
        return "accident/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident) {
       String n = accident.getName();
        System.out.println("Имя что пришло : " + n);
        accidents.create(accident);
        return "redirect:/";
    }
}
