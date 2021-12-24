package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.service.AccidentService;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 3. @ModelAttribute. Создание инцидента. [#261013]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
 * 3.1. @RequestParam. Форма редактирования [#308708]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
 * 4. Form с композиционным объектом [#305522]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
 * 5. Form с аргегационными объектами [#305523]
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
        var types = accidentService.getAllAccidentType();
        model.addAttribute("types", types);
        var rules = accidentService.getAllRules();
        model.addAttribute("rules", rules);
        return "accident/create";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("accident", accidentService.findById(id));
        return "accident/update";
    }

    /**
     * 5. Form с аргегационными объектами [#305523]
     * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.2. MVC
     * На стороне сервера инцидент обрабатывается через метод create().
     * Important! - Данные на контроллере мы получаем напрямую из запроса HttpRequestServlet.
     * String[] ids = request.getParameterValues("rIds");
     * create.jsp
     * <tr>
     * <td>Статьи:</td>
     * <td>
     * <select name="rIds" multiple>
     * <c:forEach var="rule" items="${rules}">
     * <option value="${rule.id}">${rule.name}</option>
     * </c:forEach>
     * </select>
     * </tr>
     * String n = accident.getName();
     * String f = accident.getText();
     * String g = accident.getAddress();
     * int id = accident.getType().getId();
     * var frd = accident.getType();
     * System.out.println("Имя что пришло : "
     * + n + " _ " + f + " _ " + g + " - type - " + frd + " id " + id);
     * Arrays.stream(ids).forEach(System.out::println);
     *
     * @param accident
     * @return
     */
    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident, HttpServletRequest request) {
        String[] ids = request.getParameterValues("rIds");
        var rslA = accidentService.putRuleToAccid(accident, ids);
        accidentService.save(rslA);
        return "redirect:/";
    }
}
