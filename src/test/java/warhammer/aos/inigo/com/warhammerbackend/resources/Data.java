package warhammer.aos.inigo.com.warhammerbackend.resources;

import java.util.Optional;

import warhammer.aos.inigo.com.warhammerbackend.models.api.Alliance;
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

    public static Optional<Alliance> createAlliance1() {
        return Optional.of(Alliance.builder()
                .id(1L)
                .name("Orruk")
                .subFaction(null)
                .clan(null)
                .grandAlliance(createGrandAlliance1().orElseThrow())
                .build());
    }

    public static Optional<Alliance> createAlliance2() {
        return Optional.of(Alliance.builder()
                .id(2L)
                .name("Ogor")
                .subFaction(null)
                .clan(null)
                .grandAlliance(createGrandAlliance1().orElseThrow())
                .build());
    }

    public static Optional<Alliance> createCompleteAlliance1() {
        return Optional.of(Alliance.builder()
                .id(2L)
                .name("Orruk")
                .subFaction("Kruleboyz")
                .clan("Big Yellers")
                .grandAlliance(createGrandAlliance1().orElseThrow())
                .build());
    }

    public static Optional<Alliance> createCompleteAlliance2() {
        return Optional.of(Alliance.builder()
                .id(2L)
                .name("Orruk")
                .subFaction("Kruleboyz")
                .clan(null)
                .grandAlliance(createGrandAlliance1().orElseThrow())
                .build());
    }

    public static Optional<Alliance> createCompleteAlliance3() {
        return Optional.of(Alliance.builder()
                .id(2L)
                .name("Orruk")
                .subFaction(null)
                .clan("Big Yellers")
                .grandAlliance(createGrandAlliance1().orElseThrow())
                .build());
    }

}
