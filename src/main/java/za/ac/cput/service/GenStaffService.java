package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.GeneralStaff;
import za.ac.cput.repository.GenStaffRepo;
import za.ac.cput.service.interfaces.IGenStaffService;

import java.util.List;

@Service
public class GenStaffService implements IGenStaffService {
    private GenStaffRepo genStaffRepo;

    @Autowired
    public GenStaffService(GenStaffRepo genStaffRepo) {
        this.genStaffRepo = genStaffRepo;
    }
}
