package warhammer.aos.inigo.com.warhammerbackend.services;

import java.util.List;
import java.util.Optional;

import warhammer.aos.inigo.com.warhammerbackend.models.Alliance;

public interface AllianceService {

    List<Alliance> findAll();

    Optional<Alliance> findById(Long id);

    Alliance save(Alliance alliance);

    Optional<Alliance> update(Long id, Alliance alliance);

    Optional<Alliance> delete(Long id);

}
