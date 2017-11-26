package net.vkfave.dao;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * Сущность, описывающая избранную запись
 */
@Entity
public class FavoriteItemDao implements Serializable {
    @Id
    @Column(name = "fave_item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @Column(name = "inner_text")
    private String text;
    
    @Column(name = "image_url")
    private String imageUrl;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDao user;
    
    @ManyToOne
    @JoinColumn(name = "album_id")
    private AlbumDao album;
    
    @ManyToMany(mappedBy = "faveItems")
    private Set<TagDao> tags;

    public FavoriteItemDao() {
    }

    public FavoriteItemDao(String name, UserDao user, 
    		AlbumDao album, String text, String imageUrl) {
    	this.name = name;
    	this.user = user; 
		this.album = album;
		this.text = text;
		this.imageUrl = imageUrl;
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public UserDao getUser() {
		return user;
	}

	public void setUser(UserDao user) {
		this.user = user;
	}

	public AlbumDao getAlbum() {
		return album;
	}

	public void setAlbum(AlbumDao album) {
		this.album = album;
	}

	@Override
    public String toString() {
        return "";
    }
}
