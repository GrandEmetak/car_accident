package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 0. Spring MVC [#6877]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
 * Обработкой вида будет заниматься контроллер. Это обычный класс с особыми аннотациями.
 * Spring сканирует проект и регистрирует этот контроллер. Когда на Dispacher приходит запрос, он ищет подходящий контроллер.
 * <p>
 * Метод index возвращает имя вида без расширения.
 */
@Controller
public class IndexControl {
    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }
}
