package warhammer.aos.inigo.com.warhammerbackend.repositories.api;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import warhammer.aos.inigo.com.warhammerbackend.models.api.Unit;
import warhammer.aos.inigo.com.warhammerbackend.models.api.dto.UnitDto;

public interface UnitRepository extends CrudRepository<Unit, Long> {

    @Query(value = "SELECT new UnitDto(u.id, u.name, u.move, u.save, u.bravery, u.wounds, u.size, u.points, "
            + "u.roleInBattle, u.notes, a.name, a.description, w.melee, w.name, w.range, w.attacks, w.toHit, "
            + "w.toWound, w.rend, w.damage) "
            + " FROM Unit u "
            + " JOIN Ability a ON u.id = a.unit.id "
            + " JOIN Weapon w ON u.id = w.unit.id "
            + " WHERE u.id = ?1")
    Optional<UnitDto> findCompletedUnit(Long id);

}
