package com.example.spring.graal.vm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Publisher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private Integer id;

    @NotBlank(message = "Name of Publisher should not be blank")
    @Size(max = 100)
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Address should not be blank")
    @Size(max = 255)
    @Column(name = "address")
    private String address;

    @NotBlank(message = "Phone Number should not be blank")
    @Column(name = "phone_number")
    @Size(max = 20)
    private String phoneNumber;

    public Publisher() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return Objects.equals(id, publisher.id) && Objects.equals(name, publisher.name) && Objects.equals(address, publisher.address) && Objects.equals(phoneNumber, publisher.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, phoneNumber);
    }
}
