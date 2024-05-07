package warhammer.aos.inigo.com.warhammerbackend.repositories;

import org.springframework.data.repository.CrudRepository;

import warhammer.aos.inigo.com.warhammerbackend.models.Unit;

public interface UnitRepository extends CrudRepository<Unit, Long> {
    
}
