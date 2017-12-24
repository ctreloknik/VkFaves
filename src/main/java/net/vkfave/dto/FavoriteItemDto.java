package net.vkfave.dto;

import java.io.Serializable;
import java.util.List;

/**
 * DTO для избранных записей
 */
public class FavoriteItemDto implements Serializable {
	private Long id;
	
	private Long vkId;

	private String name;

	private String text;

	private String imageUrl;

	private Long albumId;

	private List<TagDto> tags;

	public FavoriteItemDto() {
	}

	public FavoriteItemDto(String name, Long albumId, String text,
			String imageUrl) {
		this.name = name;
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

	public Long getVkId() {
		return vkId;
	}

	public void setVId(Long vkId) {
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

	public Long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}

	public List<TagDto> getTags() {
		return tags;
	}

	public void setTags(List<TagDto> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "FavoriteItemDto{" + "id=" + id + ", name='" + name + '\''
				+ ", text='" + text + '\'' + ", imageUrl='" + imageUrl + '\''
				+ ", albumId=" + albumId + '}';
	}
}
