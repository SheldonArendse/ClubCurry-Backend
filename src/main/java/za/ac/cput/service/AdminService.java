package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Admin;
import za.ac.cput.repository.AdminRepo;
import za.ac.cput.service.interfaces.IAdminService;

import java.util.List;

@Service
public class AdminService implements IAdminService{
    private AdminRepo adminRepo;

    @Autowired
    public AdminService(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    @Override
    public Admin save(Admin obj) {
        return adminRepo.save(obj);
    }

    @Override
    public Admin read(String s) {
        return adminRepo.findById(s).orElse(null);
    }

  
}
