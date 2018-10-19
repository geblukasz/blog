package com.akademiakodu.blog.service;

import com.akademiakodu.blog.models.dto.UserDTO;
import com.akademiakodu.blog.models.entities.User;
import com.akademiakodu.blog.repositories.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Getter
@Setter
public class UserSessionService {

    private boolean logged;
    private UserDTO userDTO;

    @Autowired
    private UserRepository userRepository;

    private ModelMapper modelMapper;

    public boolean loginUser(String userName, String password) {
        Optional<User> optionalUser = userRepository.findByUserName(userName);
        if (!optionalUser.isPresent()) {
            return false;
        }

        User user = optionalUser.get();
        if (!user.getPassword().equals(password)) {
            return false;
        }

        userDTO = modelMapper.map(user, UserDTO.class);
        logged = true;
        return logged;

    }
}
