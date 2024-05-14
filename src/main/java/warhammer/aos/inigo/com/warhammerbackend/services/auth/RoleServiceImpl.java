package warhammer.aos.inigo.com.warhammerbackend.services.auth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import warhammer.aos.inigo.com.warhammerbackend.models.auth.Role;
import warhammer.aos.inigo.com.warhammerbackend.repositories.auth.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Role> findAll() {
        return (List<Role>) repository.findAll();
    }

    @Override
    @Transactional
    public Role save(Role role) {
        return repository.save(role);
    }

}
