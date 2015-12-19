package ua.djhans.model;

import javax.persistence.*;

/**
 * Created by Administrator on 09.12.2015.
 */
@Entity
@Table(name = "writers")
public class Writer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "writer_id")
    private int id;

    @Column(name = "name_en")
    private String nameEn;

    @Column(name = "name_rus")
    private String nameRus;

    public Writer() {}

    public int getId() {
        return id;
    }

    public String getNameEn() {
        return nameEn;
    }

    public String getNameRus() {
        return nameRus;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public void setNameRus(String nameRus) {
        this.nameRus = nameRus;
    }

    @Override
    public String toString() {
        return getNameRus() + " (" + getNameEn() + ")";
    }
}
