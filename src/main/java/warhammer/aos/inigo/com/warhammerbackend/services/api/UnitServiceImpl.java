package warhammer.aos.inigo.com.warhammerbackend.services.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import warhammer.aos.inigo.com.warhammerbackend.models.api.Unit;
import warhammer.aos.inigo.com.warhammerbackend.models.api.dto.UnitDto;
import warhammer.aos.inigo.com.warhammerbackend.repositories.api.UnitRepository;

@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    private UnitRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Unit> findAll() {
        return (List<Unit>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Unit> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Unit save(Unit unit) {
        return repository.save(unit);
    }

    @Override
    @Transactional
    public Optional<Unit> update(Long id, Unit unit) {
        Optional<Unit> uOptional = repository.findById(id);

        if (uOptional.isPresent()) {
            Unit uni = uOptional.orElseThrow();

            uni.setName(unit.getName());
            uni.setSave(unit.getSave());
            uni.setMove(unit.getMove());
            uni.setWounds(unit.getWounds());
            uni.setBravery(unit.getBravery());
            uni.setSize(unit.getSize());
            uni.setPoints(unit.getPoints());
            uni.setRoleInBattle(unit.getRoleInBattle());
            uni.setNotes(unit.getNotes());
            uni.setAlliance(unit.getAlliance());

            return Optional.of(repository.save(uni));
        }

        return uOptional;
    }

    @Override
    @Transactional
    public Optional<Unit> delete(Long id) {
        Optional<Unit> uOptional = repository.findById(id);

        uOptional.ifPresent(uni -> repository.delete(uni));

        return uOptional;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UnitDto> findCompletedUnit(Long id) {
        return repository.findCompletedUnit(id);
    }

}
