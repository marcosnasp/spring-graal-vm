module com.example.spring.graal.vm {
    requires java.base;
    requires spring.beans;
    requires spring.web;
    requires spring.boot;
    requires spring.context;
    requires spring.core;
    requires spring.data.jpa;
    requires spring.boot.autoconfigure;
    requires jakarta.persistence;
    requires jakarta.validation;
    requires org.hibernate.orm.core;

    opens com.example.spring.graal.vm;
    opens com.example.spring.graal.vm.model;
    opens com.example.spring.graal.vm.exceptions;
    opens com.example.spring.graal.vm.controller;
    opens com.example.spring.graal.vm.repository;
    opens com.example.spring.graal.vm.services;
}