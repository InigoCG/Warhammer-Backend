package warhammer.aos.inigo.com.warhammerbackend.repositories;

import org.springframework.data.repository.CrudRepository;

import warhammer.aos.inigo.com.warhammerbackend.models.Weapon;

public interface WeaponRepository extends CrudRepository<Weapon, Long> {
    
}
