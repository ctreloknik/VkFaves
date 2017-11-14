package net.imadness.abe.models.dto;

import net.imadness.abe.models.Board;

import javax.validation.constraints.NotNull;

/**
 * Created by Валерий on 08.07.2016.
 */
public class BoardDto {
    private Long id;
    @NotNull
    private String name;

    public BoardDto() {
    }

    public BoardDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Board createBoard() {
        Board result = new Board();
        result.setName(this.name);
        result.setId(this.id);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BoardDto)) return false;

        BoardDto boardDto = (BoardDto) o;

        if (id != null ? !id.equals(boardDto.id) : boardDto.id != null) return false;
        return name != null ? name.equals(boardDto.name) : boardDto.name == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
