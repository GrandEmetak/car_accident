package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * 0. Spring MVC [#6877]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
 * Обработкой вида будет заниматься контроллер. Это обычный класс с особыми аннотациями.
 * Spring сканирует проект и регистрирует этот контроллер. Когда на Dispacher приходит запрос, он ищет подходящий контроллер.
 * <p>
 * Метод index возвращает имя вида без расширения.
 * 1. Загрузка данных в вид [#295782]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
 * мы передадим данные из контроллера в вид.
 * Метод index принимает объект Model. Этот тот же HttpServletRequest,
 * в который можно добавить параметры.
 *  model.addAttribute("user", "Petr Arsentev"); -  получать в jsp по атрибуьу user  ${user}
 * -. Добавьте в проект bootstap и выведите на нем таблицу List<String> через jstl.
 */
@Controller
public class IndexControl {

    @GetMapping("/")
    public String index(Model model) {
        List<String> stringList = new ArrayList<>();
        stringList.add("Petr Arsentev");
        stringList.add("Sam Brown");
        stringList.add("John Smith");

        model.addAttribute("user", "Petr Arsentev");
        model.addAttribute("clients", stringList);
        return "index";
    }
}
