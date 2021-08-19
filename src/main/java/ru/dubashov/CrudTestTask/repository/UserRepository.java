package ru.dubashov.CrudTestTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dubashov.CrudTestTask.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
