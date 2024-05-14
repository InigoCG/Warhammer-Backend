package warhammer.aos.inigo.com.warhammerbackend.controllers.auth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import warhammer.aos.inigo.com.warhammerbackend.controllers.helpers.ValidationControllerHelper;
import warhammer.aos.inigo.com.warhammerbackend.models.auth.Role;
import warhammer.aos.inigo.com.warhammerbackend.services.auth.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService service;

    @Autowired
    private ValidationControllerHelper helper;

    @GetMapping
    public List<Role> list() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Role role, BindingResult result) {
        if (result.hasFieldErrors()) {
            return helper.validation(result);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(role));
    }

}
