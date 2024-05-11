package warhammer.aos.inigo.com.warhammerbackend.controllers.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import warhammer.aos.inigo.com.warhammerbackend.controllers.api.helpers.ValidationControllerHelper;
import warhammer.aos.inigo.com.warhammerbackend.models.api.Weapon;
import warhammer.aos.inigo.com.warhammerbackend.services.api.WeaponService;

@RestController
@RequestMapping("/api/weapon")
public class WeaponController {

    @Autowired
    private WeaponService service;

    @Autowired
    private ValidationControllerHelper helper;

    @GetMapping
    public List<Weapon> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(@PathVariable Long id) {
        Optional<Weapon> aOptional = service.findById(id);

        if (aOptional.isPresent()) {
            return ResponseEntity.ok(aOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Weapon weapon, BindingResult result) {
        if (result.hasErrors()) {
            return helper.validation(result);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(weapon));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Weapon weapon, BindingResult result, @PathVariable Long id) {
        if (result.hasErrors()) {
            return helper.validation(result);
        }

        Optional<Weapon> aOptional = service.update(id, weapon);
        if (aOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(aOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delte(@PathVariable Long id) {
        Optional<?> aOptional = service.delete(id);

        if (aOptional.isPresent()) {
            return ResponseEntity.ok(aOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

}
