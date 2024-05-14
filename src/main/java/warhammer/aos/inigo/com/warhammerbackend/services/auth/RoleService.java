package warhammer.aos.inigo.com.warhammerbackend.services.auth;

import java.util.List;

import warhammer.aos.inigo.com.warhammerbackend.models.auth.Role;

public interface RoleService {
    
    List<Role> findAll();

    Role save(Role role);

}
