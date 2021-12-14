package ru.job4j.accident.repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.List;

/**
 *  бин работает с хранилищем, класс для работы с базой.
 * 0. Spring DataSource [#6878]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.3. Template, ORM
 */
@Repository
public class AccidentJdbcTemplate {
    private final JdbcTemplate jdbc;

    public AccidentJdbcTemplate(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Accident save(Accident accident) {
        jdbc.update("insert into accident (name) values (?)",
                accident.getName());
        return accident;
    }

    public List<Accident> getAll() {
        return jdbc.query("select id, name from accident",
                (rs, row) -> {
                    Accident accident = new Accident();
                    accident.setId(rs.getInt("id"));
                    accident.setName(rs.getString("name"));
                    return accident;
                });
    }
}
