package warhammer.aos.inigo.com.warhammerbackend.services.auth;

import java.util.List;

import warhammer.aos.inigo.com.warhammerbackend.models.auth.User;

public interface UserService {

    List<User> findAll();

    User save(User user);

}
