package warhammer.aos.inigo.com.warhammerbackend.repositories.api;

import org.springframework.data.repository.CrudRepository;

import warhammer.aos.inigo.com.warhammerbackend.models.api.Ability;

public interface AbilityRepository extends CrudRepository<Ability, Long> {
    
}
