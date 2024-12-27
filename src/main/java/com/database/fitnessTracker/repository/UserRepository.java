package com.database.fitnessTracker.repository;


import com.database.fitnessTracker.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByLogin(String firstName);

    Optional<Users> findByEmail(String Email);

    @Transactional
    @Modifying
    @Query(value = "update \"Users\" set role = 'ADMIN' where id = ?1", nativeQuery = true)
    void changeToAdmin(Integer userId);

    @Transactional
    @Modifying
    @Query(value = "update \"Users\" set role = 'USER' where id = ?1", nativeQuery = true)
    void changeToUser(Integer userId);
}
