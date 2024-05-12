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
import warhammer.aos.inigo.com.warhammerbackend.models.api.GrandAlliance;
import warhammer.aos.inigo.com.warhammerbackend.services.api.GrandAllianceService;

@RestController
@RequestMapping("/api/grand-alliance")
public class GrandAllianceController {

    @Autowired
    private GrandAllianceService service;

    @Autowired
    private ValidationControllerHelper helper;

    @GetMapping
    public List<GrandAlliance> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(@PathVariable Long id) {
        Optional<GrandAlliance> grOptional = service.findById(id);

        if (grOptional.isPresent()) {
            return ResponseEntity.ok(grOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody GrandAlliance grandAlliance, BindingResult result) {
        if (result.hasFieldErrors()) {
            return helper.validation(result);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(grandAlliance));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody GrandAlliance grandAlliance, BindingResult result,
            @PathVariable Long id) {
        if (result.hasErrors()) {
            return helper.validation(result);
        }

        Optional<GrandAlliance> grOptional = service.update(id, grandAlliance);
        if (grOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(grOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<?> grOptional = service.delete(id);

        if (grOptional.isPresent()) {
            return ResponseEntity.ok(grOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

}
