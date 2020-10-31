package ru.job4j.car_accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.car_accident.models.AccidentType;

import java.util.HashMap;
import java.util.List;

@Repository
public class AccidentTypeMem implements MemStore<AccidentType> {

    private static int ACCIDENT_TYPE_COUNTER;
    private final HashMap<Integer, AccidentType> accidentTypes;

    {
        accidentTypes = new HashMap<>();
        accidentTypes.put(++ACCIDENT_TYPE_COUNTER,
                AccidentType.of(ACCIDENT_TYPE_COUNTER, "Две машины"));
        accidentTypes.put(++ACCIDENT_TYPE_COUNTER,
                AccidentType.of(ACCIDENT_TYPE_COUNTER, "Машина и человек"));
        accidentTypes.put(++ACCIDENT_TYPE_COUNTER,
                AccidentType.of(ACCIDENT_TYPE_COUNTER, "Машина и велосипед"));
    }

    @Override
    public void save(AccidentType accidentType) {
        accidentType.setId(++ACCIDENT_TYPE_COUNTER);
        accidentTypes.put(ACCIDENT_TYPE_COUNTER, accidentType);
    }

    @Override
    public List<AccidentType> getAll() {
        return List.copyOf(accidentTypes.values());
    }

    @Override
    public AccidentType findById(int id) {
        return accidentTypes.get(id);
    }

    @Override
    public void update(AccidentType accidentType) {
        this.accidentTypes.put(accidentType.getId(), accidentType);
    }
}
