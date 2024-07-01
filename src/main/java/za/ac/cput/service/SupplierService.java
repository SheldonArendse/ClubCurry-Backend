package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Supplier;
import za.ac.cput.repository.SupplierRepo;
import za.ac.cput.service.interfaces.ISupplierService;

import java.util.List;

@Service
public class SupplierService implements ISupplierService {

    private SupplierRepo supplierRepo;

    @Autowired
    public SupplierService(SupplierRepo supplierRepo) {
        this.supplierRepo = supplierRepo;
    }

    @Override
    public Supplier save(Supplier obj) {
        return supplierRepo.save(obj);
    }

    @Override
    public Supplier read(Long aLong) {
        return supplierRepo.findById(aLong).orElse(null);
    }

    @Override
    public Supplier update(Supplier obj) {
        if(supplierRepo.existsById(obj.getId())){
            return supplierRepo.save(obj);
        }
        return null;
    }

    @Override
    public Boolean delete(Long aLong) {
        if(supplierRepo.existsById(aLong)){
            supplierRepo.deleteById(aLong);
            return true;
        }
        return false;
    }

    @Override
    public List<Supplier> getAll() {
        return supplierRepo.findAll();
    }
}
