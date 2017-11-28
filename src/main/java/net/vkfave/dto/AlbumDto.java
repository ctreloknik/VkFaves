package net.vkfave.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * DTO для альбомов
 */
public class AlbumDto implements Serializable {
    private Long id;

    @NotNull
    private String name;

    private Long userId;

    public AlbumDto() {
    }

    public AlbumDto(String name, Long userId) {
        this.name = name;
        this.userId = userId;
    }

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
    
    public Long getUserId() {
        return userId;
    }

    public void setUser(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "AlbumDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userId=" + userId +
                '}';
    }
}
