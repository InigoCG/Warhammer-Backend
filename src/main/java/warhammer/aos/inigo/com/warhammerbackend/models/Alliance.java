package warhammer.aos.inigo.com.warhammerbackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "alliance")
public class Alliance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    private String clan;

    @ManyToOne
    @JoinColumn(name = "grand_alliance_id")
    private GrandAlliance grandAlliance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GrandAlliance getGrandAlliance() {
        return grandAlliance;
    }

    public void setGrandAlliance(GrandAlliance grandAlliance) {
        this.grandAlliance = grandAlliance;
    }

    public String getClan() {
        return clan;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }

}
