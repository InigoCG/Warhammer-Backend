package warhammer.aos.inigo.com.warhammerbackend.models.api;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "unit")
@Getter
@Setter
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private Integer move;

    @NotNull
    private Integer save;

    @NotNull
    private Integer bravery;

    @NotNull
    private Integer wounds;

    @NotNull
    private Integer size;

    @NotNull
    private Integer points;

    @Column(name = "role_in_battle")
    private String roleInBattle;

    private String notes;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alliance_id")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Alliance alliance;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "unit")
    private List<Ability> abilities;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "unit")
    private List<KeyName> keyNames;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "unit")
    private List<UnitKit> unitKits;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "unit")
    private List<Weapon> weapons;

    public Unit() {
        abilities = new ArrayList<>();
        keyNames = new ArrayList<>();
        unitKits = new ArrayList<>();
        weapons = new ArrayList<>();
    }

}
