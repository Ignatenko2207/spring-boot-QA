package info.sjd.controller;

import info.sjd.entity.Order;
import info.sjd.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    
    @Autowired
    OrderService orderService;
    
    @PostMapping
    ResponseEntity<Order> save(@RequestBody Order order){
        Order savedOrder = orderService.save(order);
        if (savedOrder != null){
            return new ResponseEntity(savedOrder, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
    
    @GetMapping("/find/{id}")
    ResponseEntity<Order> findById(@PathVariable Integer id){
        return new ResponseEntity(orderService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/find-by-period")
    ResponseEntity<Order> findAllByTime(@RequestBody Long timeFrom,
                                        @RequestBody Long timeTo){
        return new ResponseEntity(orderService.findAllByTime(timeFrom, timeTo), HttpStatus.OK);
    }
    
    @PutMapping
    ResponseEntity<Order> update(@RequestBody Order order){
        Order savedOrder = orderService.update(order);
        if (savedOrder != null){
            return new ResponseEntity(savedOrder, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
    
    @DeleteMapping("/{id}")
    ResponseEntity<Order> delete(@PathVariable Integer id){
        orderService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
