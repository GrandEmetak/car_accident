package com.autoviolation.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * этим выражением мы говорим Хайбирнэту что для связи с классом Accident
 * в талице которая связана с нашим классом Rule есть столбец - accident_id
 * -@ManyToOne(много rule может быть в одном Ассидент)
 *
 * -@JoinColumn(мы всегда прописываем столбец foreign_key)
 * - @JoinColumn(name = "accident_id") - на основе каких полей строятся эти отношения
 *  private Accident accident;
 */
@Entity
@Table(name = "rules")
public class Rule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = {CascadeType.PERSIST,
            CascadeType.DETACH,
            CascadeType.PERSIST,
            CascadeType.MERGE})
    @JoinColumn(name = "accident_id")
    private Accident accident;

    public Rule() {
    }

    public Rule(String name, Accident accident) {
        this.name = name;
        this.accident = accident;
    }

    public static Rule of(int id, String name) {
        Rule rule = new Rule();
        rule.id = id;
        rule.name = name;
        return rule;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Accident getAccident() {
        return accident;
    }

    public void setAccident(Accident accident) {
        this.accident = accident;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Rule rule = (Rule) o;
        return id == rule.id && Objects.equals(name, rule.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return String.format("Rule: id=%s, name=%s",
                id, name);
    }
}
