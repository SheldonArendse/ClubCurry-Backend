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
}
