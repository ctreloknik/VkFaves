package net.vkfave.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 * Сущность, описывающая пользователя
 */
@Entity
public class UserDao implements Serializable {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @Column(name = "vk_id")
    private Long vkId;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<AlbumDao> albums = new ArrayList<>();

    public UserDao() {
    }

    public UserDao(String name, Long vkId) {
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

    public void setVkId(Long vk_id) {
        this.vkId = vkId;
    }

    @Override
    public String toString() {
        return "";
    }
}
