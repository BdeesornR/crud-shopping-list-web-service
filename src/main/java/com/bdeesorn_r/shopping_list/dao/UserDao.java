package com.bdeesorn_r.shopping_list.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(schema = "shopping_list", name = "sl_user")
public class UserDao extends CommonDao {
    @Id
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "salt")
    private byte[] salt;

    @Column(name = "hashed_password")
    private byte[] hashedPassword;
}
