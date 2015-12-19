package ua.djhans.model;

import javax.persistence.*;


/**
 * Created by Administrator on 08.12.2015.
 */

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;

    @Column(name = "title_en")
    private String titleEn;

    @Column(name = "title_rus")
    private String titleRus;

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER, targetEntity = Writer.class)
    @JoinColumn(name = "author_id")
    private Writer writer;


    public Book() {}

    public int getId() {
        return id;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public String getTitleRus() {
        return titleRus;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public void setTitleRus(String titleRus) {
        this.titleRus = titleRus;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    @Override
    public String toString() {
        return titleRus + " (" + titleEn +"), " + writer.getNameRus() + " (" + writer.getNameEn() + ")";
    }
}
