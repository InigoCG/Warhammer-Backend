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
import warhammer.aos.inigo.com.warhammerbackend.controllers.helpers.ValidationControllerHelper;
import warhammer.aos.inigo.com.warhammerbackend.models.api.Unit;
import warhammer.aos.inigo.com.warhammerbackend.models.api.dto.UnitDto;
import warhammer.aos.inigo.com.warhammerbackend.services.api.UnitService;

@RestController
@RequestMapping("/api/unit")
public class UnitController {

    @Autowired
    private UnitService service;

    @Autowired
    private ValidationControllerHelper helper;

    @GetMapping
    public List<UnitDto> list() {
        return service.findAllUnits();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findOneUnit(@PathVariable Long id) {
        Optional<UnitDto> uOptional = service.findOneUnit(id);

        if (uOptional.isPresent()) {
            return ResponseEntity.ok(uOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/complete")
    public List<Unit> completeList() {
        return service.findAll();
    }

    @GetMapping("/complete/{id}")
    public ResponseEntity<?> findOne(@PathVariable Long id) {
        Optional<Unit> uOptional = service.findById(id);

        if (uOptional.isPresent()) {
            return ResponseEntity.ok(uOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Unit unit, BindingResult result) {
        if (result.hasFieldErrors()) {
            return helper.validation(result);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(unit));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Unit unit, BindingResult result, @PathVariable Long id) {
        if (result.hasErrors()) {
            return helper.validation(result);
        }

        Optional<Unit> uOptional = service.update(id, unit);
        if (uOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(uOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<?> uOptional = service.delete(id);

        if (uOptional.isPresent()) {
            return ResponseEntity.ok(uOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

}
