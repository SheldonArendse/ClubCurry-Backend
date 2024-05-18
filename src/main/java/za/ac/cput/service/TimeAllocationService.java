package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.TimeAllocation;
import za.ac.cput.repository.TimeAllocationRepository;

import java.util.List;

@Service
public class TimeAllocationService implements ITimeAllocationService {

    private TimeAllocationRepository timeAllocationRepository;

    @Autowired
    public TimeAllocationService(TimeAllocationRepository timeAllocationRepository) {
        this.timeAllocationRepository = timeAllocationRepository;
    }

    @Override
    public TimeAllocation create(TimeAllocation obj) {
        return timeAllocationRepository.save(obj);
    }

    @Override
    public TimeAllocation read(String s) {
        return timeAllocationRepository.findById(s).orElse(null);
    }

    @Override
    public TimeAllocation update(TimeAllocation obj) {
        return timeAllocationRepository.save(obj);
    }

    @Override
    public void delete(TimeAllocation obj) {
        timeAllocationRepository.delete(obj);
    }

    @Override
    public List<TimeAllocation> getAll() {
        return timeAllocationRepository.findAll();
    }
}
