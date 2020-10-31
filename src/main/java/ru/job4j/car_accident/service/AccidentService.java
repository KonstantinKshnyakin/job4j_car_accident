package ru.job4j.car_accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.car_accident.models.Accident;
import ru.job4j.car_accident.repository.AccidentMem;

import java.util.HashMap;
import java.util.List;

@Service
public class AccidentService {

    private final AccidentMem accidentMem;

    public AccidentService(AccidentMem accidentMem) {
        this.accidentMem = accidentMem;
    }

    public void save(Accident accident) {
        accidentMem.save(accident);
    }

    public List<Accident> getAllAccidents() {
        return accidentMem.getAllAccidents();
    }
    public Accident findById(int id) {
        return accidentMem.findById(id);
    }

    public void update(Accident accident) {
        accidentMem.update(accident);
    }
}
