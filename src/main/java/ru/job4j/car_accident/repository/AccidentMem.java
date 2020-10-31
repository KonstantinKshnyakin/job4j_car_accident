package ru.job4j.car_accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.car_accident.models.Accident;

import java.util.HashMap;
import java.util.List;

@Repository
public class AccidentMem implements MemStore<Accident> {

    private static int ACCIDENT_COUNTER;
    private final HashMap<Integer, Accident> accidents;

    {
        accidents = new HashMap<>();
        String acc1s = String.valueOf(++ACCIDENT_COUNTER);
        accidents.put(ACCIDENT_COUNTER, new Accident(ACCIDENT_COUNTER, acc1s, acc1s, acc1s));
        String acc2s = String.valueOf(++ACCIDENT_COUNTER);
        accidents.put(ACCIDENT_COUNTER, new Accident(ACCIDENT_COUNTER, acc2s, acc2s, acc2s));
        String acc3s = String.valueOf(++ACCIDENT_COUNTER);
        accidents.put(ACCIDENT_COUNTER, new Accident(ACCIDENT_COUNTER, acc3s, acc3s, acc3s));
    }

    @Override
    public void save(Accident accident) {
        accident.setId(++ACCIDENT_COUNTER);
        accidents.put(ACCIDENT_COUNTER, (accident));
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
