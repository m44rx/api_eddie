package mi.prueba.api_eddie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mi.prueba.api_eddie.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
}
