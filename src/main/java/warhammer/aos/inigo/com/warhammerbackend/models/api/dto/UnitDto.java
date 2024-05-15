package warhammer.aos.inigo.com.warhammerbackend.models.api.dto;

public interface UnitDto {
    Long getId();

    String getName();

    Integer getMove();

    Integer getSave();

    Integer getBravery();

    Integer getWounds();

    Integer getSize();

    Integer getPoints();

    String getRoleInBattle();

    String getNotes();
}
