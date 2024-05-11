package warhammer.aos.inigo.com.warhammerbackend.services.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import warhammer.aos.inigo.com.warhammerbackend.models.api.Alliance;
import warhammer.aos.inigo.com.warhammerbackend.repositories.api.AllianceRepository;

@Service
public class AllianceServiceImpl implements AllianceService {

    @Autowired
    private AllianceRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Alliance> findAll() {
        return (List<Alliance>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Alliance> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Alliance save(Alliance alliance) {
        return repository.save(alliance);
    }

    @Transactional
    @Override
    public Optional<Alliance> update(Long id, Alliance alliance) {
        Optional<Alliance> aOptional = repository.findById(id);

        if (aOptional.isPresent()) {
            Alliance alli = aOptional.orElseThrow();

            alli.setName(alliance.getName());
            alli.setGrandAlliance(alliance.getGrandAlliance());
            alli.setClan(alliance.getClan());
            alli.setSubFaction(alliance.getSubFaction());

            return Optional.of(repository.save(alli));
        }

        return aOptional;
    }

    @Transactional
    @Override
    public Optional<Alliance> delete(Long id) {
        Optional<Alliance> aOptional = repository.findById(id);

        aOptional.ifPresent(alli -> repository.delete(alli));

        return aOptional;
    }

}
