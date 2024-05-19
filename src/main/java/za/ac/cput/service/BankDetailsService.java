package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.BankDetails;
import za.ac.cput.repository.BankDetailsRepository;

import java.util.List;

@Service
public class BankDetailsService implements IService<BankDetails, String> {
    private BankDetailsRepository repository;

    @Autowired
    public BankDetailsService(BankDetailsRepository repository) {
        this.repository = repository;
    }

    @Override
    public BankDetails create(BankDetails obj) {
        return repository.save(obj);
    }

    @Override
    public BankDetails read(String s) {
        return repository.findById(s).orElse(null);
    }

    @Override
    public void delete(BankDetails obj) {
        repository.delete(obj);
    }

    @Override
    public List<BankDetails> getAll() {
        return repository.findAll();
    }
}
