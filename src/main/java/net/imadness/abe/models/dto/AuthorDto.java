package net.imadness.abe.models.dto;

import net.imadness.abe.models.Author;

public class AuthorDto {
    private Long id;
    private String nickname;
    private String ipAddress;
    
    public AuthorDto() {
    }
    
    /**
     * Конструктор для уже существующего пользователя
     * @param id
     * @param nickname
     */
    public AuthorDto(Long id, String nickname, String ipAddress) {
        this.id = id;
        this.nickname = nickname;
        this.ipAddress = ipAddress;
    }
    
    /**
     * Создаёт на основе инкапсулированных данных соответствющий доменный объект {@link Author}
     * @return объект сущности Author
     */
    public Author createAuthor() {
        Author result = new Author();
        result.setId(this.id);
        result.setNickname(this.nickname);
        result.setIpAddress(this.ipAddress);
        return result;
    }
    
    /**
     * Конструктор для объекта AuthorDto без ID
     * @param nickname
     */
    public AuthorDto(String nickname) {
        this.nickname = nickname;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuthorDto)) return false;

        AuthorDto authorDto = (AuthorDto) o;

        if (id != null ? !id.equals(authorDto.id) : authorDto.id != null) return false;
        if (nickname != null ? !nickname.equals(authorDto.nickname) : authorDto.nickname != null) return false;
        return ipAddress != null ? ipAddress.equals(authorDto.ipAddress) : authorDto.ipAddress == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (ipAddress != null ? ipAddress.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AuthorDto{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                '}';
    }
}