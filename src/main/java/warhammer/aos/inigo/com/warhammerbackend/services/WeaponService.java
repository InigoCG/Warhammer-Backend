package warhammer.aos.inigo.com.warhammerbackend.services;

import java.util.List;
import java.util.Optional;

import warhammer.aos.inigo.com.warhammerbackend.models.Weapon;

public interface WeaponService {
    
    List<Weapon> findAll();

    Optional<Weapon> findById(Long id);

    Weapon save(Weapon weapon);

    Optional<Weapon> update(Long id, Weapon weapon);

    Optional<Weapon> delete(Long id);

}
