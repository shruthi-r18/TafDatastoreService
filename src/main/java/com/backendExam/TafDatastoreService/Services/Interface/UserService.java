package com.backendExam.TafDatastoreService.Services.Interface;

import com.backendExam.TafDatastoreService.Models.User;

import java.util.List;

public interface UserService {
    User add(User user);

    User get(Long id);

    User update(Long id, User user);

}
