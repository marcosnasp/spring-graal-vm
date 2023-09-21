package com.example.spring.graal.vm.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(schema = "public", name = "book_category")
public class BookCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_category_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "bookCategory")
    private List<Book> book;

    public BookCategory() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookCategory that = (BookCategory) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(book, that.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, book);
    }
}