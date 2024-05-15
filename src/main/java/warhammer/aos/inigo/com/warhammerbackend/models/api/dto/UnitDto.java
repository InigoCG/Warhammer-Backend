package warhammer.aos.inigo.com.warhammerbackend.models.api.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UnitDto {

    @Id
    private Long id;

    private String unitName;
    private Integer move;
    private Integer save;
    private Integer bravery;
    private Integer wounds;
    private Integer size;
    private Integer points;
    private String roleInBattle;
    private String notes;

    private String abilityName;
    private String abilityDescription;

    private Boolean melee;
    private String WeaponName;
    private Integer range;
    private Integer attacks;
    private Integer toHit;
    private Integer toWound;
    private Integer rend;
    private Integer damage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Integer getMove() {
        return move;
    }

    public void setMove(Integer move) {
        this.move = move;
    }

    public Integer getSave() {
        return save;
    }

    public void setSave(Integer save) {
        this.save = save;
    }

    public Integer getBravery() {
        return bravery;
    }

    public void setBravery(Integer bravery) {
        this.bravery = bravery;
    }

    public Integer getWounds() {
        return wounds;
    }

    public void setWounds(Integer wounds) {
        this.wounds = wounds;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getRoleInBattle() {
        return roleInBattle;
    }

    public void setRoleInBattle(String roleInBattle) {
        this.roleInBattle = roleInBattle;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getAbilityName() {
        return abilityName;
    }

    public void setAbilityName(String abilityName) {
        this.abilityName = abilityName;
    }

    public String getAbilityDescription() {
        return abilityDescription;
    }

    public void setAbilityDescription(String abilityDescription) {
        this.abilityDescription = abilityDescription;
    }

    public Boolean getMelee() {
        return melee;
    }

    public void setMelee(Boolean melee) {
        this.melee = melee;
    }

    public String getWeaponName() {
        return WeaponName;
    }

    public void setWeaponName(String weaponName) {
        WeaponName = weaponName;
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

    public void setAttacks(Integer attacks) {
        this.attacks = attacks;
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

    public UnitDto() {
    }

    public UnitDto(Long id, String unitName, Integer move, Integer save, Integer bravery, Integer wounds, Integer size,
            Integer points, String roleInBattle, String notes, String abilityName, String abilityDescription,
            Boolean melee, String weaponName, Integer range, Integer attacks, Integer toHit, Integer toWound,
            Integer rend, Integer damage) {
        this.id = id;
        this.unitName = unitName;
        this.move = move;
        this.save = save;
        this.bravery = bravery;
        this.wounds = wounds;
        this.size = size;
        this.points = points;
        this.roleInBattle = roleInBattle;
        this.notes = notes;
        this.abilityName = abilityName;
        this.abilityDescription = abilityDescription;
        this.melee = melee;
        WeaponName = weaponName;
        this.range = range;
        this.attacks = attacks;
        this.toHit = toHit;
        this.toWound = toWound;
        this.rend = rend;
        this.damage = damage;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((unitName == null) ? 0 : unitName.hashCode());
        result = prime * result + ((move == null) ? 0 : move.hashCode());
        result = prime * result + ((save == null) ? 0 : save.hashCode());
        result = prime * result + ((bravery == null) ? 0 : bravery.hashCode());
        result = prime * result + ((wounds == null) ? 0 : wounds.hashCode());
        result = prime * result + ((size == null) ? 0 : size.hashCode());
        result = prime * result + ((points == null) ? 0 : points.hashCode());
        result = prime * result + ((roleInBattle == null) ? 0 : roleInBattle.hashCode());
        result = prime * result + ((notes == null) ? 0 : notes.hashCode());
        result = prime * result + ((abilityName == null) ? 0 : abilityName.hashCode());
        result = prime * result + ((abilityDescription == null) ? 0 : abilityDescription.hashCode());
        result = prime * result + ((melee == null) ? 0 : melee.hashCode());
        result = prime * result + ((WeaponName == null) ? 0 : WeaponName.hashCode());
        result = prime * result + ((range == null) ? 0 : range.hashCode());
        result = prime * result + ((attacks == null) ? 0 : attacks.hashCode());
        result = prime * result + ((toHit == null) ? 0 : toHit.hashCode());
        result = prime * result + ((toWound == null) ? 0 : toWound.hashCode());
        result = prime * result + ((rend == null) ? 0 : rend.hashCode());
        result = prime * result + ((damage == null) ? 0 : damage.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UnitDto other = (UnitDto) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (unitName == null) {
            if (other.unitName != null)
                return false;
        } else if (!unitName.equals(other.unitName))
            return false;
        if (move == null) {
            if (other.move != null)
                return false;
        } else if (!move.equals(other.move))
            return false;
        if (save == null) {
            if (other.save != null)
                return false;
        } else if (!save.equals(other.save))
            return false;
        if (bravery == null) {
            if (other.bravery != null)
                return false;
        } else if (!bravery.equals(other.bravery))
            return false;
        if (wounds == null) {
            if (other.wounds != null)
                return false;
        } else if (!wounds.equals(other.wounds))
            return false;
        if (size == null) {
            if (other.size != null)
                return false;
        } else if (!size.equals(other.size))
            return false;
        if (points == null) {
            if (other.points != null)
                return false;
        } else if (!points.equals(other.points))
            return false;
        if (roleInBattle == null) {
            if (other.roleInBattle != null)
                return false;
        } else if (!roleInBattle.equals(other.roleInBattle))
            return false;
        if (notes == null) {
            if (other.notes != null)
                return false;
        } else if (!notes.equals(other.notes))
            return false;
        if (abilityName == null) {
            if (other.abilityName != null)
                return false;
        } else if (!abilityName.equals(other.abilityName))
            return false;
        if (abilityDescription == null) {
            if (other.abilityDescription != null)
                return false;
        } else if (!abilityDescription.equals(other.abilityDescription))
            return false;
        if (melee == null) {
            if (other.melee != null)
                return false;
        } else if (!melee.equals(other.melee))
            return false;
        if (WeaponName == null) {
            if (other.WeaponName != null)
                return false;
        } else if (!WeaponName.equals(other.WeaponName))
            return false;
        if (range == null) {
            if (other.range != null)
                return false;
        } else if (!range.equals(other.range))
            return false;
        if (attacks == null) {
            if (other.attacks != null)
                return false;
        } else if (!attacks.equals(other.attacks))
            return false;
        if (toHit == null) {
            if (other.toHit != null)
                return false;
        } else if (!toHit.equals(other.toHit))
            return false;
        if (toWound == null) {
            if (other.toWound != null)
                return false;
        } else if (!toWound.equals(other.toWound))
            return false;
        if (rend == null) {
            if (other.rend != null)
                return false;
        } else if (!rend.equals(other.rend))
            return false;
        if (damage == null) {
            if (other.damage != null)
                return false;
        } else if (!damage.equals(other.damage))
            return false;
        return true;
    }

}
