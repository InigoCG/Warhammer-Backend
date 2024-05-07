package warhammer.aos.inigo.com.warhammerbackend.services;

import java.util.List;
import java.util.Optional;

import warhammer.aos.inigo.com.warhammerbackend.models.GrandAlliance;

public interface GrandAllianceService {

    List<GrandAlliance> findAll();

    Optional<GrandAlliance> findById(Long id);

    GrandAlliance save(GrandAlliance grandAlliance);

    Optional<GrandAlliance> update(Long id, GrandAlliance grandAlliance);

    Optional<GrandAlliance> delete(Long id);

}
