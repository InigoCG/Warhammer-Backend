package warhammer.aos.inigo.com.warhammerbackend.services.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import warhammer.aos.inigo.com.warhammerbackend.models.api.GrandAlliance;
import warhammer.aos.inigo.com.warhammerbackend.repositories.api.GrandAllianceRepository;

@Service
public class GrandAllianceServiceImpl implements GrandAllianceService {

    @Autowired
    private GrandAllianceRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<GrandAlliance> findAll() {
        return (List<GrandAlliance>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<GrandAlliance> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public GrandAlliance save(GrandAlliance grandAlliance) {
        return repository.save(grandAlliance);
    }

    @Override
    public Optional<GrandAlliance> update(Long id, GrandAlliance grandAlliance) {
        Optional<GrandAlliance> grOptional = repository.findById(id);

        if (grOptional.isPresent()) {
            GrandAlliance grAlliance = grOptional.orElseThrow();

            grAlliance.setName(grandAlliance.getName());

            return Optional.of(repository.save(grAlliance));
        }

        return grOptional;
    }

    @Transactional
    @Override
    public Optional<GrandAlliance> delete(Long id) {
        Optional<GrandAlliance> grOptional = repository.findById(id);

        grOptional.ifPresent(grAlliance -> repository.delete(grAlliance));

        return grOptional;
    }

}
