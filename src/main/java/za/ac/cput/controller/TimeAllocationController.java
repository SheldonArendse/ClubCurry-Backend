package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.TimeAllocation;
import za.ac.cput.factory.TimeAllocationFactory;
import za.ac.cput.service.TimeAllocationService;

import java.sql.Time;
import java.util.List;

@RestController
@RequestMapping("/timeAllocation")
public class TimeAllocationController {

    private TimeAllocationService timeAllocationService;

    @Autowired
    public TimeAllocationController(TimeAllocationService timeAllocationService) {
        this.timeAllocationService = timeAllocationService;
    }

    @PostMapping("/create")
    public TimeAllocation create(@RequestBody TimeAllocation obj) {
        TimeAllocation ta1 = TimeAllocationFactory.buildTimeAllocation(obj.getTimerId(), obj.getOrder(), obj.getDatePrepared(), obj.getPreparedBy());
        return timeAllocationService.create(ta1);
    }

    @GetMapping("/read/{id}")
    public TimeAllocation read(@PathVariable String id) {
        return timeAllocationService.read(id);
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        TimeAllocation ta1 = TimeAllocationFactory.buildTimeAllocation(id);
        timeAllocationService.delete(ta1);
    }

    @PostMapping("/getAll")
    public List<TimeAllocation> getAll() {
        return timeAllocationService.getAll();
    }
}
