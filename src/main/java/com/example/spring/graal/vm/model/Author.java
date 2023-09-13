package com.example.spring.graal.vm.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Integer id;

    @NotBlank(message = "First Name should not be Blank")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Last Name should not be blank")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "Birth date should not be blank")
    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "bio")
    private String bio;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

    public Author() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) && Objects.equals(firstName, author.firstName) && Objects.equals(lastName, author.lastName) && Objects.equals(birthDate, author.birthDate) && Objects.equals(bio, author.bio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, birthDate, bio);
    }
}
