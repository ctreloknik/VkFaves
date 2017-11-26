package net.vkfave.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

/**
 * Сущность, описывающая теги
 */
@Entity
public class Tag implements Serializable {
    @Id
    @Column(name = "tag_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    private Set<FavoriteItem> faveItems;

    public Tag() {
    }

    public Tag(String name, User user) {
        this.name = name;
        this.user = user;
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
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "";
    }
}
