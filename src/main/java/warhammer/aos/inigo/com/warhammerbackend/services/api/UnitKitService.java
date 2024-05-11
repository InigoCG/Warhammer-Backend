package warhammer.aos.inigo.com.warhammerbackend.services.api;

import java.util.List;
import java.util.Optional;

import warhammer.aos.inigo.com.warhammerbackend.models.api.UnitKit;

public interface UnitKitService {
    
    List<UnitKit> findAll();

    Optional<UnitKit> findById(Long id);

    UnitKit save(UnitKit unitKit);

    Optional<UnitKit> update(Long id, UnitKit unitKit);

    Optional<UnitKit> delete(Long id);

}
