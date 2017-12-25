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
 * Сущность, описывающая URL для постов
 */
@Entity
public class Image implements Serializable {
    @Id
    @Column(name = "image_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String url;

    @ManyToOne
    @JoinColumn(name = "fave_id")
    private FavoriteItem fave;

    public Image() {
    }

    public Image(String url, FavoriteItem fave) {
        this.url = url;
        this.fave = fave;
    }

    public Long getId() {
        return id;
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

	public FavoriteItem getFave() {
		return fave;
	}

	public void setFave(FavoriteItem fave) {
		this.fave = fave;
	}
}
