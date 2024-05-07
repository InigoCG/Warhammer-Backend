package warhammer.aos.inigo.com.warhammerbackend.services;

import java.util.List;
import java.util.Optional;

import warhammer.aos.inigo.com.warhammerbackend.models.UnitKit;

public interface UnitKitService {
    
    List<UnitKit> findAll();

    Optional<UnitKit> findById(Long id);

    UnitKit save(UnitKit unitKit);

    Optional<UnitKit> update(Long id, UnitKit unitKit);

    Optional<UnitKit> delete(Long id);

}
