package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Cart;
import za.ac.cput.facade.AddItemToCart;
import za.ac.cput.facade.CustomerCart;
import za.ac.cput.factory.CartFactory;
import za.ac.cput.service.CartService;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private CartService cartService;
    private CustomerCart customerCart;
    private AddItemToCart addItemToCart;

    @Autowired
    public CartController(CartService cartService, CustomerCart customerCart,AddItemToCart addItemToCart) {
        this.cartService = cartService;
        this.customerCart = customerCart;
        this.addItemToCart = addItemToCart;
    }

    @PostMapping("/save")
    public ResponseEntity<Cart> save(@RequestBody Cart obj){
        Cart cart = CartFactory.buildCart(obj.getCustomer());
        if(customerCart.canSave(cart) == null){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }
        Cart reObj = cartService.save(cart);
        if(reObj== null){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(reObj);
    }
}
