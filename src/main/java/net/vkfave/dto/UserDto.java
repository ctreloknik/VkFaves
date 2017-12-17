package net.vkfave.dto;

import javax.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO для пользователей
 */
public class UserDto implements Serializable {
    private Long id;

    @NotNull
    private String name;

    private Long vkId;
    
    public UserDto() {
    }

    public UserDto(String name, Long vkId) {
        this.name = name;
        this.vkId = vkId;
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
    
    public Long getVkId() {
        return vkId;
    }

    public void setVkId(Long vkId) {
        this.vkId = vkId;
    }

	@Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vkId=" + vkId +
                '}';
    }
}
