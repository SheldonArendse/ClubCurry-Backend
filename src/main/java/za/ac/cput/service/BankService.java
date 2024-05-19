package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Bank;
import za.ac.cput.repository.BankRepository;

import java.util.List;

@Service
public class BankService implements IService<Bank, String> {
    private BankRepository repository;

    @Autowired
    public BankService(BankRepository repository) {
        this.repository = repository;
    }

    @Override
    public Bank create(Bank obj) {
        return repository.save(obj);
    }

    @Override
    public Bank read(String s) {
        return repository.findById(s).orElse(null);
    }

    @Override
    public void delete(Bank obj) {
        repository.delete(obj);
    }

    @Override
    public List<Bank> getAll() {
        return repository.findAll();
    }
}
