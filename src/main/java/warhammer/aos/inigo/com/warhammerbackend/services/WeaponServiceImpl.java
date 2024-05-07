package warhammer.aos.inigo.com.warhammerbackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import warhammer.aos.inigo.com.warhammerbackend.models.Weapon;
import warhammer.aos.inigo.com.warhammerbackend.repositories.WeaponRepository;

@Service
public class WeaponServiceImpl implements WeaponService {

    @Autowired
    private WeaponRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Weapon> findAll() {
        return (List<Weapon>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Weapon> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Weapon save(Weapon weapon) {
        return repository.save(weapon);
    }

    @Override
    @Transactional
    public Optional<Weapon> update(Long id, Weapon weapon) {
        Optional<Weapon> wOptional = repository.findById(id);

        if (wOptional.isPresent()) {
            Weapon weap = wOptional.orElseThrow();

            weap.setName(weapon.getName());
            weap.setMelee(weapon.getMelee());
            weap.setAttack(weapon.getAttack());
            weap.setRange(weapon.getRange());
            weap.setToHit(weapon.getToHit());
            weap.setToWound(weapon.getToWound());
            weap.setRend(weapon.getRend());
            weap.setDamage(weapon.getDamage());
            weap.setUnit(weapon.getUnit());

            return Optional.of(repository.save(weap));
        }

        return wOptional;
    }

    @Override
    @Transactional
    public Optional<Weapon> delete(Long id) {
        Optional<Weapon> wOptional = repository.findById(id);

        wOptional.ifPresent(weap -> repository.delete(weap));

        return wOptional;
    }

}
