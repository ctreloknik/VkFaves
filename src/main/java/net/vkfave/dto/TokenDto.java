package net.vkfave.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * DTO для пользовательских токенов
 */
public class TokenDto implements Serializable {
    private Long id;

    @NotNull
    private String token;

    private Long userId;

    public TokenDto() {
    }

    public TokenDto(Long id, String token, Long userId) {
    	this.id = id;
        this.token = token;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "TagDto{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", userId=" + userId +
                '}';
    }
}
