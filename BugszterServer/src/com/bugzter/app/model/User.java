package com.bugzter.app.model;

import com.fererlab.dto.Model;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import javax.persistence.*;

/**
 * acm | 1/16/13
 */

@Entity
@Table(name = "bugzter_user")
@XStreamAlias("user")
public class User implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "username")
    String username;

    @Column(name = "password")
    String password;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String serialNumber) {
        this.username = serialNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
