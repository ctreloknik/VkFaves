package net.vkfave.dto;

import javax.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO для изображений
 */
public class ImageDto implements Serializable {
    private Long id;

    @NotNull
    private String url;

    private Long faveId;

    public ImageDto() {
    }

    public Long getId() {
        return id;
    }

    public ImageDto(Long id, String url, Long faveId) {
		super();
		this.id = id;
		this.url = url;
		this.faveId = faveId;
	}

	public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getFaveId() {
		return faveId;
	}

	public void setFaveId(Long faveId) {
		this.faveId = faveId;
	}

	@Override
    public String toString() {
        return "TagDto{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", faveId=" + faveId +
                '}';
    }
}
