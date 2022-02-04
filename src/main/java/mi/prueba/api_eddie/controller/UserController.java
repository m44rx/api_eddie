package mi.prueba.api_eddie.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mi.prueba.api_eddie.entity.User;
import mi.prueba.api_eddie.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/new")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveUser(user));
    }

    @GetMapping(value="/todo")
    public ResponseEntity<List<User>> lEntity() {
        return ResponseEntity.ok(service.findByAll());
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<User> searchUser(@PathVariable Integer id) {
        Optional <User> oUser = service.findById(id);
        if(!oUser.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(oUser.get());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Integer id){
        Optional<User> oUser = service.findById(id);
        if(!oUser.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteUser(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(name = "id", required = true) Integer id, @RequestBody User newUser){
        Optional<User> oUser = service.findById(id);
        if(!oUser.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        oUser.get().setName(newUser.getName());
        oUser.get().setLastname(newUser.getLastname());
        oUser.get().setYOld(newUser.getYOld());
        return ResponseEntity.status(HttpStatus.OK).body(service.saveUser(oUser.get()));
    }



    
    





    
}
