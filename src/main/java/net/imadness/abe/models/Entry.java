package net.imadness.abe.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Сущность, описывающая запись, содержащуюся на доске
 */
@Entity
public class Entry implements Serializable {
    @Id
    @Column(name = "entry_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String content;

    @NotNull
    private Date date;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    public Entry() {
    }

    public Entry(String content, Date date, Board board) {
        this.content = content;
        this.date = date;
        this.board = board;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", board=" + board +
                '}';
    }
}
