package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Cart;
import za.ac.cput.facade.CustomerCart;
import za.ac.cput.factory.CartFactory;
import za.ac.cput.service.CartService;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private CartService cartService;
    private CustomerCart customerCart;

    @Autowired
    public CartController(CartService cartService, CustomerCart customerCart) {
        this.cartService = cartService;
        this.customerCart = customerCart;
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

    @GetMapping("read/{id}")
    public ResponseEntity<Cart> read(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(cartService.read(id));
    }

    @PutMapping("/updateItems")
    public ResponseEntity<Cart> updateItems(@RequestBody Cart obj){
        Cart cart = cartService.read(obj.getId());
        if(cart == null){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }
        Cart cartUpdate = new Cart.Builder().copy(cart).setItems(obj.getItems()).build();
        return ResponseEntity.status(HttpStatus.OK).body(cartService.update(cartUpdate));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(cartService.delete(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Cart>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(cartService.getAll());
    }
}
