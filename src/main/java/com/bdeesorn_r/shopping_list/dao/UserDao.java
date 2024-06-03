package com.bdeesorn_r.shopping_list.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column(name = "username")
    protected String username;

    @Column(name = "email")
    protected String email;

    @Column(name = "salt")
    protected String salt;

    @Column(name = "hashed_password")
    protected String hashedPassword;
}
