package ru.job4j.car_accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.car_accident.models.AccidentType;

import java.util.HashMap;
import java.util.List;

@Repository
public class AccidentTypeMem implements MemStore<AccidentType> {

    private static int ACCIDENT_COUNTER;
    private final HashMap<Integer, AccidentType> accidentType;

    {
        accidentType = new HashMap<>();
        String acc1s = String.valueOf(++ACCIDENT_COUNTER);
        accidentType.put(ACCIDENT_COUNTER, AccidentType.of(ACCIDENT_COUNTER, "Две машины"));
        String acc2s = String.valueOf(++ACCIDENT_COUNTER);
        accidentType.put(ACCIDENT_COUNTER, AccidentType.of(ACCIDENT_COUNTER, "Машина и человек"));
        String acc3s = String.valueOf(++ACCIDENT_COUNTER);
        accidentType.put(ACCIDENT_COUNTER, AccidentType.of(ACCIDENT_COUNTER, "Машина и велосипед"));
    }

    @Override
    public void save(AccidentType accidentType) {
        accidentType.setId(++ACCIDENT_COUNTER);
        this.accidentType.put(ACCIDENT_COUNTER, (accidentType));
    }

    @Override
    public List<AccidentType> getAll() {
        return List.copyOf(accidentType.values());
    }

    @Override
    public AccidentType findById(int id) {
        return accidentType.get(id);
    }

    @Override
    public void update(AccidentType accidentType) {
        this.accidentType.put(accidentType.getId(), accidentType);
    }
}
