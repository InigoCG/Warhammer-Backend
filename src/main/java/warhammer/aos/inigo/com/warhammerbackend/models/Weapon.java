package warhammer.aos.inigo.com.warhammerbackend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    private Integer range;

    @NotNull
    private Integer attack;

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

    @ManyToOne
    @JoinColumn(name = "unit_id")
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

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
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
