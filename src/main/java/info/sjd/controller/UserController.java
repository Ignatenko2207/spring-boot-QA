package info.sjd.controller;

import info.sjd.entity.User;
import info.sjd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    ResponseEntity<User> save(@RequestBody User user){
        User savedUser = userService.save(user);
        if (savedUser != null){
            return new ResponseEntity(savedUser, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/find/{id}")
    ResponseEntity<User> findById(@PathVariable Integer id){
        return new ResponseEntity(userService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/find")
    ResponseEntity<User> findAll(){
        return new ResponseEntity(userService.findAll(), HttpStatus.OK);
    }


    @PutMapping
    ResponseEntity<User> update(@RequestBody User user){
        User savedUser = userService.update(user);
        if (savedUser != null){
            return new ResponseEntity(savedUser, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<User> delete(@PathVariable Integer id){
        userService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
