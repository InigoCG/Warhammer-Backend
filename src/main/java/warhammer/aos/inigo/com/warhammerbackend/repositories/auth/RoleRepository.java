package warhammer.aos.inigo.com.warhammerbackend.repositories.auth;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import warhammer.aos.inigo.com.warhammerbackend.models.auth.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
    
    Optional<Role> findByName(String name);

}
