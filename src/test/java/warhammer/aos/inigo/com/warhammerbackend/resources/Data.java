package warhammer.aos.inigo.com.warhammerbackend.resources;

import java.util.Optional;

import warhammer.aos.inigo.com.warhammerbackend.models.api.GrandAlliance;

public class Data {

    public static Optional<GrandAlliance> createGrandAlliance1() {
        return Optional.of(GrandAlliance.builder()
                .id(1L)
                .name("Destruction")
                .build());
    }

    public static Optional<GrandAlliance> createGrandAlliance2() {
        return Optional.of(GrandAlliance.builder()
                .id(2L)
                .name("Chaos")
                .build());
    }

}
