package mi.prueba.api_eddie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mi.prueba.api_eddie.entity.Cliente;
import mi.prueba.api_eddie.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    public Optional<Cliente> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Cliente> findByAll() {
        return repository.findAll();
    }

    @Override
    public Cliente save(Cliente t) {
        return repository.save(t);
    }

    @Override
    public Boolean delete(int id) {
        boolean rpta = false;
        if(repository.existsById(id)){
            repository.deleteById(id);
            rpta = true;
        }
        return rpta;
    }
    
}
