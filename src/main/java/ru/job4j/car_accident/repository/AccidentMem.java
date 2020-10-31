package ru.job4j.car_accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.car_accident.models.Accident;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AccidentMem {

    private static int ACCIDENT_COUNTER;
    private HashMap<Integer, Accident> accidents;

    {
        accidents = new HashMap<>();
        String acc1s = String.valueOf(++ACCIDENT_COUNTER);
        accidents.put(ACCIDENT_COUNTER, new Accident(ACCIDENT_COUNTER, acc1s, acc1s, acc1s));
        String acc2s = String.valueOf(++ACCIDENT_COUNTER);
        accidents.put(ACCIDENT_COUNTER, new Accident(ACCIDENT_COUNTER, acc2s, acc2s, acc2s));
        String acc3s = String.valueOf(++ACCIDENT_COUNTER);
        accidents.put(ACCIDENT_COUNTER, new Accident(ACCIDENT_COUNTER, acc3s, acc3s, acc3s));
    }

    public void save(Accident accident) {
        accident.setId(++ACCIDENT_COUNTER);
        accidents.put(ACCIDENT_COUNTER, (accident));
    }

    public List<Accident> getAllAccidents() {
        return List.copyOf(accidents.values());
    }

    public Accident findById(int id) {
        return accidents.get(id);
    }

    public void update(Accident accident) {
        accidents.put(accident.getId(), accident);
    }
}
