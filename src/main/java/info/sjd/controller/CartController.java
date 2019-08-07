package info.sjd.controller;

import info.sjd.entity.Cart;
import info.sjd.entity.User;
import info.sjd.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/cart")
public class CartController {
    
    @Autowired
    CartService cartService;
    
    @PostMapping
    ResponseEntity<Cart> save(@RequestBody Cart cart){
        Cart savedCart = cartService.save(cart);
        if (savedCart != null){
            return new ResponseEntity(savedCart, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
    
    @GetMapping("/{id}")
    ResponseEntity<Cart> findById(@PathVariable Integer id){
        return new ResponseEntity(cartService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/find-by-user")
    ResponseEntity<List> findAllByUser(@PathVariable User user){
        return new ResponseEntity(cartService.findAllByUser(user), HttpStatus.OK);
    }
    
    @PutMapping
    ResponseEntity<Cart> update(@PathVariable Cart cart){
        Cart savedCart = cartService.update(cart);
        if (savedCart != null){
            return new ResponseEntity(savedCart, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
    
    @DeleteMapping
    @GetMapping("/{id}")
    ResponseEntity<Cart> delete(Integer id){
        cartService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
