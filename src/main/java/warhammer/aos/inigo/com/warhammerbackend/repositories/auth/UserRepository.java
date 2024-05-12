package warhammer.aos.inigo.com.warhammerbackend.repositories.auth;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import warhammer.aos.inigo.com.warhammerbackend.models.auth.User;

public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);

}
