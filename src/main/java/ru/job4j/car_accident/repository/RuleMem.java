package ru.job4j.car_accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.car_accident.models.Rule;

import java.util.HashMap;
import java.util.List;

@Repository
public class RuleMem implements MemStore<Rule> {

    private static int RULE_COUNTER;
    private final HashMap<Integer, Rule> rules;

    {
        rules = new HashMap<>();
        rules.put(++RULE_COUNTER, Rule.of(RULE_COUNTER, "Статья. 1"));
        rules.put(++RULE_COUNTER, Rule.of(RULE_COUNTER, "Статья. 2"));
        rules.put(++RULE_COUNTER, Rule.of(RULE_COUNTER, "Статья. 3"));
    }

    @Override
    public void save(Rule rule) {
        rule.setId(++RULE_COUNTER);
        rules.put(RULE_COUNTER, rule);
    }

    @Override
    public List<Rule> getAll() {
        return List.copyOf(rules.values());

    }

    @Override
    public Rule findById(int id) {
        return rules.get(id);
    }

    @Override
    public void update(Rule rule) {
        this.rules.put(rule.getId(), rule);
    }
}
