package warhammer.aos.inigo.com.warhammerbackend.services;

import java.util.List;
import java.util.Optional;

import warhammer.aos.inigo.com.warhammerbackend.models.KeyName;

public interface KeyNameService {
    
    List<KeyName> findAll();

    Optional<KeyName> findById(Long id);

    KeyName save(KeyName keyName);

    Optional<KeyName> update(Long id, KeyName keyName);

    Optional<KeyName> delete(Long id);

}
