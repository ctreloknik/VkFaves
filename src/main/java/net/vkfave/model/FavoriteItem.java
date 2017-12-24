package net.vkfave.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * Сущность, описывающая избранную запись
 */
@Entity
public class FavoriteItem implements Serializable {
    @Id
    @Column(name = "fave_item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "vk_id")
    private Long vkId;
    
    private String name;

    @Column(name = "inner_text")
    private String text;
    
    @Column(name = "image_url")
    private String imageUrl;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;
    
    @ManyToMany(mappedBy = "faveItems")
    private List<Tag> tags;

    public FavoriteItem() {
    }

    public FavoriteItem(String name, User user,
                        Album album, String text, String imageUrl) {
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

	public Long getVkId() {
		return vkId;
	}

	public void setVkId(Long vkId) {
		this.vkId = vkId;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

    public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	@Override
    public String toString() {
        return "FavoriteItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", user=" + user.getId() +
                ", album=" + album +
                '}';
    }
}
