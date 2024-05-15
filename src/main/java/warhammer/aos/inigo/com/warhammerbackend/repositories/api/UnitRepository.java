package warhammer.aos.inigo.com.warhammerbackend.repositories.api;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import warhammer.aos.inigo.com.warhammerbackend.models.api.Unit;
import warhammer.aos.inigo.com.warhammerbackend.models.api.dto.UnitDto;

public interface UnitRepository extends CrudRepository<Unit, Long> {

    @Query(value = "SELECT u.id, u.name, u.move, u.save, u.bravery, u.wounds, u.size, u.points, u.role_in_battle, "
            + " u.notes FROM unit u WHERE u.id = ?1", nativeQuery = true)
    Optional<UnitDto> findOneUnit(Long id);

    @Query(value = "SELECT u.id, u.name, u.move, u.save, u.bravery, u.wounds, u.size, u.points, u.role_in_battle, "
    + " u.notes FROM unit u", nativeQuery = true)
    List<UnitDto> findAllUnits();

}
