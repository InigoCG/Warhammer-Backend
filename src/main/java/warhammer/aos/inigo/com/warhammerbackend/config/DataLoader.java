package warhammer.aos.inigo.com.warhammerbackend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import warhammer.aos.inigo.com.warhammerbackend.enums.Roles;
import warhammer.aos.inigo.com.warhammerbackend.models.auth.Role;
import warhammer.aos.inigo.com.warhammerbackend.repositories.auth.RoleRepository;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private RoleRepository repository;

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() != 0) {
            return;
        }

        repository.save(Role.builder().id(1L).name(Roles.ROLE_ADMIN.name()).build());
        repository.save(Role.builder().id(2L).name(Roles.ROLE_USER.name()).build());
    }

}
