package com.bdeesorn_r.shopping_list.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bdeesorn_r.shopping_list.dao.UserDao;

@Repository
public interface UserRepo extends JpaRepository<UserDao, Long> {
    //
}
