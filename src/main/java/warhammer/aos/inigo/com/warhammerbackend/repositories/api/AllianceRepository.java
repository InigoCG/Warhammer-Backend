package warhammer.aos.inigo.com.warhammerbackend.repositories.api;

import org.springframework.data.repository.CrudRepository;

import warhammer.aos.inigo.com.warhammerbackend.models.api.Alliance;

public interface AllianceRepository extends CrudRepository<Alliance, Long> {
    
}
