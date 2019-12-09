package com.zemoso.busbooking.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    public List<User> findAllByDeleted(Boolean deleted);
    public Optional<User> findByIdAndDeleted(Integer id, Boolean deleted);

    public User getOneByIdAndDeleted(Integer id, Boolean deleted);
    public User getOneByEmailAndDeleted(String email, Boolean deleted);
    Boolean existsByEmail(String email);
}
