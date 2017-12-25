package net.vkfave.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Сущность, описывающая пользователя
 */
@Entity
@Table(name = "system_user")
public class User implements Serializable {
	@Id
	@Column(name = "user_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name", nullable = true)
	private String name;

	@Column(name = "vk_id", nullable = false)
	private Long vkId;

	@Column(name = "token", nullable = false)
	private String token;

	@Column(name = "last_auth_date")
	private Date lastAuthDate;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Album> albums = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Tag> tags = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Token> tokens = new ArrayList<>();

	public User() {
	}

	public User(String name, Long vkId) {
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public List<Token> getTokens() {
		return tokens;
	}

	public void setTokens(List<Token> tokens) {
		this.tokens = tokens;
	}

	public Date getLastAuthDate() {
		return lastAuthDate;
	}

	public void setLastAuthDate(Date lastAuthDate) {
		this.lastAuthDate = lastAuthDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof User))
			return false;

		User user = (User) o;

		if (id != null ? !id.equals(user.id) : user.id != null)
			return false;
		if (name != null ? !name.equals(user.name) : user.name != null)
			return false;
		if (vkId != null ? !vkId.equals(user.vkId) : user.vkId != null)
			return false;
		return albums != null ? albums.equals(user.albums)
				: user.albums == null;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, vkId);
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", name='" + name + '\'' + ", vkId="
				+ vkId + ", albums=" + albums + '}';

	}
}
