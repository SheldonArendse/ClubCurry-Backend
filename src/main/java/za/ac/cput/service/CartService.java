package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Cart;
import za.ac.cput.repository.AddressRepo;
import za.ac.cput.repository.CartRepo;
import za.ac.cput.service.interfaces.ICartService;
import za.ac.cput.service.interfaces.IService;

import java.util.List;

@Service
public class CartService implements ICartService {

    private CartRepo cartRepo;

    @Autowired
    public CartService(CartRepo cartRepo) {
        this.cartRepo = cartRepo;
    }

    @Override
    public Cart save(Cart obj) {
        return cartRepo.save(obj);
    }

    @Override
    public Cart read(Long s) {
        return cartRepo.findById(s).orElse(null);
    }

    @Override
    public Cart update(Cart obj) {
        if(cartRepo.existsById(obj.getId())){
            return cartRepo.save(obj);
        }
        return null;
    }

    @Override
    public Boolean delete(Long s) {
        if(cartRepo.existsById(s)){
            cartRepo.deleteById(s);
            return true;
        }
        return false;
    }

    @Override
    public List<Cart> getAll() {
        return cartRepo.findAll();
    }
}
