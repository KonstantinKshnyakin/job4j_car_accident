package ru.job4j.car_accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.car_accident.models.Accident;
import ru.job4j.car_accident.repository.AccidentMem;

import java.util.HashMap;

@Service
public class AccidentService {

    private final AccidentMem accidentMem;

    public AccidentService(AccidentMem accidentMem) {
        this.accidentMem = accidentMem;
    }

    public void add(Accident accident) {
        accidentMem.add(accident);
    }

    public HashMap<Integer, Accident> getAllAccidents() {
        return accidentMem.getAllAccidents();
    }
}
