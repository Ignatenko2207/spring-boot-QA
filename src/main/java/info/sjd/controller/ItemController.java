package info.sjd.controller;

import info.sjd.entity.Item;
import info.sjd.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/item")
public class ItemController {
    
    @Autowired
    ItemService itemService;
    
    @PostMapping
    ResponseEntity<Item> save(@RequestBody Item item){
        Item savedItem = itemService.save(item);
        if (savedItem != null){
            return new ResponseEntity(savedItem, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
    
    @GetMapping("/{id}")
    ResponseEntity<Item> findById(Integer id){
        return new ResponseEntity(itemService.findById(id), HttpStatus.OK);
    }
    
    @PutMapping
    ResponseEntity<Item> update(@RequestBody Item item){
        Item savedItem = itemService.update(item);
        if (savedItem != null){
            return new ResponseEntity(savedItem, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
    
    @DeleteMapping
    @GetMapping("/{id}")
    ResponseEntity<Item> delete(Integer id){
        itemService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
