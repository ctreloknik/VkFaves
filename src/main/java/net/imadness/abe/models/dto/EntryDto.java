package net.imadness.abe.models.dto;

import net.imadness.abe.models.Entry;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Data Transfer Object для сущности Entry
 */
public class EntryDto {
    @NotNull
    private String content;
    @NotNull
    private String author;
    private Long date;
    private Long authorId;
    private Long boardId;

    public EntryDto() {
    }

    public EntryDto(String content, Long date, Long authorId, Long boardId) {
        this.content = content;
        this.date = date;
        this.authorId = authorId;
        this.boardId = boardId;
    }

    public Entry createEntry() {
        Entry result = new Entry();
        result.setContent(this.content);
        result.setDate(new Date(this.date));
        return result;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EntryDto)) return false;

        EntryDto entryDto = (EntryDto) o;

        if (content != null ? !content.equals(entryDto.content) : entryDto.content != null) return false;
        if (author != null ? !author.equals(entryDto.author) : entryDto.author != null) return false;
        if (date != null ? !date.equals(entryDto.date) : entryDto.date != null) return false;
        if (authorId != null ? !authorId.equals(entryDto.authorId) : entryDto.authorId != null) return false;
        return boardId != null ? boardId.equals(entryDto.boardId) : entryDto.boardId == null;

    }

    @Override
    public int hashCode() {
        int result = content != null ? content.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (authorId != null ? authorId.hashCode() : 0);
        result = 31 * result + (boardId != null ? boardId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EntryDto{" +
                "content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", date=" + date +
                ", authorId=" + authorId +
                ", boardId=" + boardId +
                '}';
    }
}
