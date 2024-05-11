package warhammer.aos.inigo.com.warhammerbackend.repositories.auth;

import org.springframework.data.repository.CrudRepository;

import warhammer.aos.inigo.com.warhammerbackend.models.auth.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
