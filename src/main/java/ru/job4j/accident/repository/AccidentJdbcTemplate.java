package ru.job4j.accident.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * бин работает с хранилищем, класс для работы с базой.
 * класс отключен, проект производит работу через Hibernate
 * и его класс настройки HbmConfig
 */
/*@Repository*/
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
        return jdbc.query("select id, name, text, address from accident",
                (rs, row) -> {
                    Accident accident = new Accident();
                    Set<Rule> ruleSet = new HashSet<>();
                    accident.setId(rs.getInt("id"));
                    accident.setName(rs.getString("name"));
                    accident.setText(rs.getString("text"));
                    accident.setAddress(rs.getString("address"));
                    var id = rs.getInt("accident_type_id");
                    accident.setType(findAccType(id));
                    var rl = rs.getInt("rule_id");
                    ruleSet.add(findRule(id));
                    accident.setRules(ruleSet);
                    return accident;
                });
    }

    public List<AccidentType> getAllAccType() {
        return jdbc.query("select id, name from accident_types",
                (rs, row) -> {
                    AccidentType accidentT = new AccidentType();
                    accidentT.setId(rs.getInt("id"));
                    accidentT.setName(rs.getString("name"));
                    return accidentT;
                });
    }

    public AccidentType findAccType(int id) {
        return jdbc.queryForObject(
                "select id, name from accident_types where id = ?",
                (resultSet, rowNum) -> {
                    AccidentType newAcTp = new AccidentType();
                    newAcTp.setId(resultSet.getInt("id"));
                    newAcTp.setName(resultSet.getString("name"));
                    return newAcTp;
                },
                id);

    }

    public Rule findRule(int id) {
        return jdbc.queryForObject(
                "select id, name from rules where id = ?",
                (resultSet, rowNum) -> {
                    Rule rule = new Rule();
                    rule.setId(resultSet.getInt("id"));
                    rule.setName(resultSet.getString("name"));
                    return rule;
                },
                id);
    }
}
