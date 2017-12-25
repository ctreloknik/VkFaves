package net.vkfave.dto;

import java.io.Serializable;
import java.util.List;

import net.vkfave.model.User;

/**
 * DTO для пользователей
 */
public class UserDto implements Serializable {
    private Long id;
    private String name;
    private Long vkId;
    private String token;
    private List<TokenDto> tokens;
    
    public UserDto() { }

    public UserDto(String name, Long vkId) {
        this.name = name;
        this.vkId = vkId;
    }

    public UserDto(User user) {
        this.name = user.getName();
        this.vkId = user.getVkId();
        this.id = user.getId();
        this.token = user.getToken();
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

	public List<TokenDto> getTokens() {
		return tokens;
	}

	public void setTokens(List<TokenDto> tokens) {
		this.tokens = tokens;
	}
}
