package net.imadness.abe.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Сущность, описывающая автора записи
 */
@Entity
public class Author implements Serializable {

    @Id
    @Column(name = "author_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Необязательное поле (в соответствии с данной концепцией форума)
     */
    private String nickname;

    @NotNull
    private String ipAddress;

    private Boolean isBanned = false;

    public Author() {
        this.nickname = "Anonymous";
    }

    public Author(String nickname, String ipAddress) {
        this.nickname = nickname;
        this.ipAddress = ipAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Boolean getBanned() {
        return isBanned;
    }

    public void setBanned(Boolean banned) {
        isBanned = banned;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                '}';
    }
}
