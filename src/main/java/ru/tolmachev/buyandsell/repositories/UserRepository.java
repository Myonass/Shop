package ru.tolmachev.buyandsell.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tolmachev.buyandsell.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
