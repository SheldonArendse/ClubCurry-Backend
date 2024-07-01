package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.StockOrder;
import za.ac.cput.repository.StockOrderRepo;
import za.ac.cput.service.interfaces.IStockOrderService;

import java.util.List;

@Service
public class StockOrderService implements IStockOrderService {

    private StockOrderRepo stockOrderRepo;

    @Autowired
    public StockOrderService(StockOrderRepo stockOrderRepo) {
        this.stockOrderRepo = stockOrderRepo;
    }

    @Override
    public StockOrder save(StockOrder obj) {
        return stockOrderRepo.save(obj);
    }

    @Override
    public StockOrder read(Long aLong) {
        return stockOrderRepo.findById(aLong).orElse(null);
    }

    @Override
    public StockOrder update(StockOrder obj) {
        if(stockOrderRepo.existsById(obj.getId())){
            return stockOrderRepo.save(obj);
        }
        return null;
    }

    @Override
    public Boolean delete(Long aLong) {
        if(stockOrderRepo.existsById(aLong)){
            stockOrderRepo.deleteById(aLong);
            return true;
        }
        return false;
    }

    @Override
    public List<StockOrder> getAll() {
        return stockOrderRepo.findAll();
    }
}
