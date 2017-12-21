package net.vkfave.dto;

import net.vkfave.model.User;

import java.io.Serializable;

/**
 * DTO для пользователей
 */
public class UserDto implements Serializable {
    private Long id;
    private String name;
    private Long vkId;
    private String token;
    
    public UserDto() { }

    public UserDto(String name, Long vkId) {
        this.name = name;
        this.vkId = vkId;
    }

    public UserDto(User user) {
        this.name = user.getName();
        this.vkId = user.getVkId();
        this.id = user.getId();
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
