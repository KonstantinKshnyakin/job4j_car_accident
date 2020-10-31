package ru.job4j.car_accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.car_accident.models.AccidentType;
import ru.job4j.car_accident.repository.AccidentTypeMem;

import java.util.List;

@Service
public class AccidentTypeService implements Services<AccidentType> {

    private final AccidentTypeMem accidentTypeMem;

    public AccidentTypeService(AccidentTypeMem accidentTypeMem) {
        this.accidentTypeMem = accidentTypeMem;
    }

    @Override
    public void save(AccidentType accidentType) {
        accidentTypeMem.save(accidentType);
    }

    @Override
    public List<AccidentType> getAll() {
        return accidentTypeMem.getAll();
    }

    @Override
    public AccidentType findById(int id) {
        return accidentTypeMem.findById(id);
    }

    @Override
    public void update(AccidentType accidentType) {
        accidentTypeMem.update(accidentType);
    }
}
