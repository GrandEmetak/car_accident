package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.repository.AccidentMem;
import ru.job4j.accident.service.AccidentService;

import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * 3. @ModelAttribute. Создание инцидента. [#261013]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
 * 3.1. @RequestParam. Форма редактирования [#308708]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
 * 4. Form с композиционным объектом [#305522]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
 */
@Controller
public class AccidentControl {

    private AccidentService accidentService;

    public AccidentControl(AccidentService accidentService) {
        this.accidentService = accidentService;
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<AccidentType> types = new ArrayList<>();
        types.add(AccidentType.of(1, "Две машины"));
        types.add(AccidentType.of(2, "Машина и человек"));
        types.add(AccidentType.of(3, "Машина и велосипед"));
        model.addAttribute("types", types);
        return "accident/create";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("accident", accidentService.findById(id));
        return "accident/update";
    }

    /**
     * На стороне сервера инцидент обрабатывается через метод create().
     *
     * @param accident
     * @return
     */
    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident) {
        String n = accident.getName();
        String f = accident.getText();
        String g = accident.getAddress();
        int id = accident.getType().getId();
        var frd = accident.getType();
        System.out.println("Имя что пришло : "
                + n + " _ " + f + " _ " + g + " - type - " + frd + " id " + id);
        accidentService.create(accident);
        return "redirect:/";
    }
}
