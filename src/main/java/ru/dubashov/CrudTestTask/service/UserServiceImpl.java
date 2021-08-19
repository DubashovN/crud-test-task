package ru.dubashov.CrudTestTask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dubashov.CrudTestTask.exception.BadRequestException;
import ru.dubashov.CrudTestTask.model.User;
import ru.dubashov.CrudTestTask.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        if (user.getName() == null ||
                user.getPhoneNumber() == null) {
            throw new BadRequestException();
        }
        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        if (isValidId(id)) {
            throw new BadRequestException();
        }
        return userRepository.findById(id).orElse(null);
    }

    private Boolean isValidId(Long id) {
        return id != null && id == Math.floor(id) && id > 0;
    }
}
