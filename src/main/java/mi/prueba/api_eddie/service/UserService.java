package mi.prueba.api_eddie.service;

import java.util.List;
import java.util.Optional;

import mi.prueba.api_eddie.entity.User;


public interface UserService {
    
    Optional<User> findById(int id);

    List<User> findByAll();

    User saveUser(User user);

    Boolean deleteUser(int id);
}
