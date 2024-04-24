package warhammer.aos.inigo.com.warhammerbackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import warhammer.aos.inigo.com.warhammerbackend.models.GrandAlliance;
import warhammer.aos.inigo.com.warhammerbackend.services.GrandAllianceService;

@RestController
@RequestMapping("/api/grandAlliance")
public class GrandAllianceController {

    @Autowired
    private GrandAllianceService service;

    @GetMapping
    public List<GrandAlliance> list() {
        return service.findAll();
    }

}
