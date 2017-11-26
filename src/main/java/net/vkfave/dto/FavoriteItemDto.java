package net.vkfave.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * Сущность, описывающая избранную запись
 */
public class FavoriteItemDto implements Serializable {
    private Long id;

    @NotNull
    private String name;

    private String text;
    
    private String imageUrl;
    
    private Long userId;
    
    private Long albumId;

    public FavoriteItemDto() {
    }

    public FavoriteItemDto(String name, Long  userId, 
    		Long albumId, String text, String imageUrl) {
    	this.name = name;
    	this.userId = userId; 
		this.albumId = albumId;
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

	public Long getUser() {
		return userId;
	}

	public void setUser(Long userId) {
		this.userId = userId;
	}

	public Long  getAlbum() {
		return albumId;
	}

	public void setAlbum(Long albumId) {
		this.albumId = albumId;
	}

	@Override
    public String toString() {
        return "";
    }
}
