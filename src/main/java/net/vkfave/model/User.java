package net.vkfave.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Сущность, описывающая пользователя
 */
@Entity
@Table(name = "system_user")
public class User implements Serializable {
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
    private List<Album> albums = new ArrayList<>();

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

    public void setVkId(Long vk_id) {
        this.vkId = vkId;
    }

    @Override
    public String toString() {
        return "";
    }
}
