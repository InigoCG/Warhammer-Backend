package warhammer.aos.inigo.com.warhammerbackend.repositories.api;

import org.springframework.data.repository.CrudRepository;

import warhammer.aos.inigo.com.warhammerbackend.models.api.Unit;

public interface UnitRepository extends CrudRepository<Unit, Long> {
    
}
