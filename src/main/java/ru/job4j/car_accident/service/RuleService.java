package ru.job4j.car_accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.car_accident.models.Rule;
import ru.job4j.car_accident.repository.RuleMem;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RuleService implements Services<Rule> {

    private final RuleMem ruleMem;

    public RuleService(RuleMem ruleMem) {
        this.ruleMem = ruleMem;
    }

    @Override
    public void save(Rule rule) {
        ruleMem.save(rule);
    }

    @Override
    public List<Rule> getAll() {
        return ruleMem.getAll();
    }

    @Override
    public Rule findById(int id) {
        return ruleMem.findById(id);
    }

    @Override
    public void update(Rule rule) {
        ruleMem.update(rule);
    }

    public Set<Rule> findListByIds(String[] ids) {
        Set<Rule> list = new HashSet<>();
        for (String id : ids) {
            list.add(findById(Integer.parseInt(id)));
        }
        return list;
    }
}
