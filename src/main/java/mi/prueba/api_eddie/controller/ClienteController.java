package mi.prueba.api_eddie.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mi.prueba.api_eddie.entity.Cliente;
import mi.prueba.api_eddie.service.ClienteService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    private ClienteService service;

    @GetMapping(value="/")
    public ResponseEntity<List<Cliente>> allCliente() {
        return ResponseEntity.ok(service.findByAll());
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> byIdCliente(@PathVariable int id) {
        Optional<Cliente> optCliente = service.findById(id);
        if (!optCliente.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(optCliente.get());
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Cliente> saveCliente(@RequestBody Cliente Cliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(Cliente));
    }


    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable int id, @RequestBody Cliente cliente) {
        Optional<Cliente> optCliente = service.findById(id);
        if (!optCliente.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        optCliente.get().setNombreCliente(cliente.getNombreCliente());
        optCliente.get().setApellidoCliente(cliente.getApellidoCliente());
        optCliente.get().setNroCelular(cliente.getNroCelular());
        optCliente.get().setDirección(cliente.getDirección());
        return ResponseEntity.status(HttpStatus.OK).body(service.save(optCliente.get()));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteCliente(@PathVariable int id) {
        Optional<Cliente> optCliente = service.findById(id);
        if (!optCliente.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));
    }

}
