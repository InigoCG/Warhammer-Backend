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

@Entity
@Table(name = "weapon")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getMelee() {
        return melee;
    }

    public void setMelee(Boolean melee) {
        this.melee = melee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

    public Integer getAttacks() {
        return attacks;
    }

    public void setAttacks(Integer attack) {
        this.attacks = attack;
    }

    public Integer getToHit() {
        return toHit;
    }

    public void setToHit(Integer toHit) {
        this.toHit = toHit;
    }

    public Integer getToWound() {
        return toWound;
    }

    public void setToWound(Integer toWound) {
        this.toWound = toWound;
    }

    public Integer getRend() {
        return rend;
    }

    public void setRend(Integer rend) {
        this.rend = rend;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    

}
