package DAO.model.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Tags {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;

    public Tags(String name) {

    }

    public Tags() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tags tags = (Tags) o;
        return id == tags.id && Objects.equals(name, tags.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
