package com.backendExam.TafDatastoreService.Services;

import com.backendExam.TafDatastoreService.Models.User;
import com.backendExam.TafDatastoreService.Repositories.UserRepository;
import com.backendExam.TafDatastoreService.Services.Interface.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User add(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User get(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }

    @Override
    public User update(Long id, User user) {
        if (this.userRepository.existsById(id)) {
            user.setUserId(id);
            return this.userRepository.save(user);
        }
        return null;
    }


}