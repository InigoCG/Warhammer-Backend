package warhammer.aos.inigo.com.warhammerbackend.services.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import warhammer.aos.inigo.com.warhammerbackend.models.api.KeyName;
import warhammer.aos.inigo.com.warhammerbackend.repositories.api.KeyNameRepository;

@Service
public class KeyNameServiceImpl implements KeyNameService {

    @Autowired
    private KeyNameRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<KeyName> findAll() {
        return (List<KeyName>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<KeyName> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public KeyName save(KeyName keyName) {
        return repository.save(keyName);
    }

    @Override
    @Transactional
    public Optional<KeyName> update(Long id, KeyName keyName) {
        Optional<KeyName> kOptional = repository.findById(id);

        if (kOptional.isPresent()) {
            KeyName kName = kOptional.orElseThrow();

            kName.setName(keyName.getName());
            kName.setUnit(keyName.getUnit());

            return Optional.of(repository.save(kName));
        }

        return kOptional;
    }

    @Override
    @Transactional
    public Optional<KeyName> delete(Long id) {
        Optional<KeyName> kOptional = repository.findById(id);

        kOptional.ifPresent(kName -> repository.delete(kName));

        return kOptional;
    }

}
