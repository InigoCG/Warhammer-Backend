package warhammer.aos.inigo.com.warhammerbackend.services.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import warhammer.aos.inigo.com.warhammerbackend.models.api.Ability;
import warhammer.aos.inigo.com.warhammerbackend.repositories.api.AbilityRepository;

@Service
public class AbilityServiceImpl implements AbilityService {

    @Autowired
    private AbilityRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Ability> findAll() {
        return (List<Ability>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Ability> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Ability save(Ability ability) {
        return repository.save(ability);
    }

    @Override
    @Transactional
    public Optional<Ability> update(Long id, Ability ability) {
        Optional<Ability> aOptional = repository.findById(id);

        if (aOptional.isPresent()) {
            Ability abi = aOptional.orElseThrow();

            abi.setName(ability.getName());
            abi.setDescription(ability.getDescription());
            abi.setUnit(ability.getUnit());

            return Optional.of(repository.save(abi));
        }

        return aOptional;
    }

    @Override
    @Transactional
    public Optional<Ability> delete(Long id) {
        Optional<Ability> aOptional = repository.findById(id);

        aOptional.ifPresent(abi -> repository.delete(abi));

        return aOptional;
    }

}
