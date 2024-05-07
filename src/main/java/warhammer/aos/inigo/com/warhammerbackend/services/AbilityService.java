package warhammer.aos.inigo.com.warhammerbackend.services;

import java.util.List;
import java.util.Optional;

import warhammer.aos.inigo.com.warhammerbackend.models.Ability;

public interface AbilityService {
    
    List<Ability> findAll();

    Optional<Ability> findById(Long id);

    Ability save(Ability ability);

    Optional<Ability> update(Long id, Ability ability);

    Optional<Ability> delete(Long id);

}
