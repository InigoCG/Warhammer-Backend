package warhammer.aos.inigo.com.warhammerbackend.repositories.api;

import org.springframework.data.repository.CrudRepository;

import warhammer.aos.inigo.com.warhammerbackend.models.api.Weapon;

public interface WeaponRepository extends CrudRepository<Weapon, Long> {
    
}
