package com.bdeesorn_r.shopping_list.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.bdeesorn_r.shopping_list.dao.UserDao;
import com.bdeesorn_r.shopping_list.dto.request.RequestUserDto;
import com.bdeesorn_r.shopping_list.dto.response.ResponseCommonDto;
import com.bdeesorn_r.shopping_list.repositories.UserRepo;

@Service
public class UserService {
    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public ResponseCommonDto createNewUser(RequestUserDto userDto) {
        UserDao user = new UserDao();

        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());

        String salt = BCrypt.gensalt();

        user.setSalt(salt);
        user.setHashedPassword(BCrypt.hashpw(userDto.getPassword(), salt));
        user.setCreatedBy(userDto.getUsername());
        user.setUpdatedBy(userDto.getUsername());

        try {
            userRepo.save(user);
        } catch (Exception e) {
            logger.error("createNewUser", e);
            return new ResponseCommonDto("500", "Cannot create user");
        }

        return new ResponseCommonDto("200", "User created successfully");
    }
}
