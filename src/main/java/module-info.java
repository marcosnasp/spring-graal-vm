module com.example.spring.graal.vm {
    requires java.base;
    requires spring.beans;
    requires spring.web;
    requires spring.boot;
    requires spring.context;
    requires spring.data.jpa;
    requires spring.boot.autoconfigure;
    requires jakarta.persistence;
    requires jakarta.validation;
    requires java.naming;
    requires java.sql;
    requires org.hibernate.orm.core;

    opens com.example.spring.graal.vm.model to org.hibernate.orm.core, jakarta.validation;

    //exports com.example.spring.graal.vm;
}