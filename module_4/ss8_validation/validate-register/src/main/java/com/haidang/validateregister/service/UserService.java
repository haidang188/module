package com.haidang.validateregister.service;

import com.haidang.validateregister.model.User;
import com.haidang.validateregister.repository.UserRepositoty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepositoty userRepositoty;
    @Override
    public void save(User user) {
        userRepositoty.save(user);
    }
}
