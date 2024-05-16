package warhammer.aos.inigo.com.warhammerbackend.models.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "weapon")
@Getter
@Setter
public class Weapon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Boolean melee;

    @NotBlank
    private String name;

    @NotNull
    @Column(name = "attack_range")
    private Integer range;

    @NotNull
    private Integer attacks;

    @NotNull
    @Column(name = "to_hit")
    private Integer toHit;

    @NotNull
    @Column(name = "to_wound")
    private Integer toWound;

    @NotNull
    private Integer rend;

    @NotNull
    private Integer damage;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_id")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Unit unit;

}
