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
@Table(name = "unit")
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

    public void setWounds(Integer wound) {
        this.wounds = wound;
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

    public Alliance getAlliance() {
        return alliance;
    }

    public void setAlliance(Alliance alliance) {
        this.alliance = alliance;
    }

}
