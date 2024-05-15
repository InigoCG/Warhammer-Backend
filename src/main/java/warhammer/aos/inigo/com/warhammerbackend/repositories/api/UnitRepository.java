package warhammer.aos.inigo.com.warhammerbackend.repositories.api;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import warhammer.aos.inigo.com.warhammerbackend.models.api.Unit;

public interface UnitRepository extends CrudRepository<Unit, Long> {

    @Query(value = "SELECT u FROM Unit u WHERE u.id = ?1")
    Optional<Unit> findCompletedUnit(Long id);

}
