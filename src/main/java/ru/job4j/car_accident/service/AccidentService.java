package ru.job4j.car_accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.car_accident.models.Accident;
import ru.job4j.car_accident.repository.AccidentMem;

import java.util.List;

@Service
public class AccidentService implements Services<Accident> {

    private final AccidentMem accidentMem;

    public AccidentService(AccidentMem accidentMem) {
        this.accidentMem = accidentMem;
    }

    @Override
    public void save(Accident accident) {
        accidentMem.save(accident);
    }

    @Override
    public List<Accident> getAll() {
        return accidentMem.getAll();
    }

    @Override
    public Accident findById(int id) {
        return accidentMem.findById(id);
    }

    @Override
    public void update(Accident accident) {
        accidentMem.update(accident);
    }
}
