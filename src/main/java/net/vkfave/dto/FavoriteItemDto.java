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

	private Long albumId;

	private List<TagDto> tags;

	private List<ImageDto> images;

	public FavoriteItemDto() {
	}

	public FavoriteItemDto(String name, Long albumId, String text) {
		this.name = name;
		this.albumId = albumId;
		this.text = text;
	}

	public List<ImageDto> getImages() {
		return images;
	}

	public void setImages(List<ImageDto> images) {
		this.images = images;
	}

	public void setVkId(Long vkId) {
		this.vkId = vkId;
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
				+ ", text='" + text + '\'' + ", albumId=" + albumId + '}';
	}
}
