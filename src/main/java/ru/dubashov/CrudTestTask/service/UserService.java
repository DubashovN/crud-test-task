package ru.dubashov.CrudTestTask.service;

import ru.dubashov.CrudTestTask.model.User;

public interface UserService {
    User createUser(User user);
    User getById(Long id);
}
