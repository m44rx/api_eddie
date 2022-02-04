package mi.prueba.api_eddie.service;

import java.util.List;

import mi.prueba.api_eddie.entity.Cliente;

public interface CommonService<T> {

    java.util.Optional<Cliente> findById(int id);

    List<T> findByAll();

    T save(T t);

    Boolean delete(int id);
}
