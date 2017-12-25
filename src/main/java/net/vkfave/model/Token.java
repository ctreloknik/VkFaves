package net.vkfave.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * Сущность, описывающая пользовательский токен
 */
@Entity
public class Token implements Serializable {
    @Id
    @Column(name = "token_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String token;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Token() {
    }

    public Token(String token, User user) {
        this.token = token;
        this.user = user;
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

	public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
