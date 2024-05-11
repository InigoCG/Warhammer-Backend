package warhammer.aos.inigo.com.warhammerbackend.services.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import warhammer.aos.inigo.com.warhammerbackend.models.api.UnitKit;
import warhammer.aos.inigo.com.warhammerbackend.repositories.api.UnitKitRepository;

@Service
public class UnitKitServiceImpl implements UnitKitService {

    @Autowired
    private UnitKitRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<UnitKit> findAll() {
        return (List<UnitKit>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UnitKit> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public UnitKit save(UnitKit unitKit) {
        return repository.save(unitKit);
    }

    @Override
    @Transactional
    public Optional<UnitKit> update(Long id, UnitKit unitKit) {
        Optional<UnitKit> uOptional = repository.findById(id);

        if (uOptional.isPresent()) {
            UnitKit uKit = uOptional.orElseThrow();

            uKit.setName(unitKit.getName());
            uKit.setDescription(unitKit.getDescription());
            uKit.setUnit(unitKit.getUnit());

            return Optional.of(repository.save(uKit));
        }

        return uOptional;
    }

    @Override
    @Transactional
    public Optional<UnitKit> delete(Long id) {
        Optional<UnitKit> uOptional = repository.findById(id);

        uOptional.ifPresent(uKit -> repository.delete(uKit));

        return uOptional;
    }

}
