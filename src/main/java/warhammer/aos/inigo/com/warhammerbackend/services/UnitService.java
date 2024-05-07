package warhammer.aos.inigo.com.warhammerbackend.services;

import java.util.List;
import java.util.Optional;

import warhammer.aos.inigo.com.warhammerbackend.models.Unit;

public interface UnitService {
    
    List<Unit> findAll();

    Optional<Unit> findById(Long id);

    Unit save(Unit unit);

    Optional<Unit> update(Long id, Unit unit);

    Optional<Unit> delete(Long id);

}
