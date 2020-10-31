package ru.job4j.car_accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.car_accident.models.Accident;
import ru.job4j.car_accident.models.AccidentType;
import ru.job4j.car_accident.models.Rule;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Repository
public class AccidentMem implements MemStore<Accident> {

    private static int ACCIDENT_COUNTER;
    private final HashMap<Integer, Accident> accidents;

    {
        accidents = new HashMap<>();
        Rule rule1 = Rule.of(1, "Статья. 1");
        Rule rule2 = Rule.of(2, "Статья. 2");
        Rule rule3 = Rule.of(3, "Статья. 3");
        AccidentType type = AccidentType.of(1, "Две машины");
        String acc1s = String.valueOf(++ACCIDENT_COUNTER);
        accidents.put(ACCIDENT_COUNTER,
                Accident.of(ACCIDENT_COUNTER, acc1s, acc1s, acc1s, type, Set.of(rule1, rule2, rule3)));
        String acc2s = String.valueOf(++ACCIDENT_COUNTER);
        accidents.put(ACCIDENT_COUNTER,
                Accident.of(ACCIDENT_COUNTER, acc2s, acc2s, acc2s, type, Set.of(rule2, rule3)));
        String acc3s = String.valueOf(++ACCIDENT_COUNTER);
        accidents.put(ACCIDENT_COUNTER,
                Accident.of(ACCIDENT_COUNTER, acc3s, acc3s, acc3s, type, Set.of(rule2)));
    }

    @Override
    public void save(Accident accident) {
        accident.setId(++ACCIDENT_COUNTER);
        accidents.put(ACCIDENT_COUNTER, accident);
    }

    @Override
    public List<Accident> getAll() {
        return List.copyOf(accidents.values());
    }

    @Override
    public Accident findById(int id) {
        return accidents.get(id);
    }

    @Override
    public void update(Accident accident) {
        accidents.put(accident.getId(), accident);
    }
}
