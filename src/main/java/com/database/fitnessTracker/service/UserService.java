package com.database.fitnessTracker.service;

import com.database.fitnessTracker.Exceptions.UnknownUserException;
import com.database.fitnessTracker.entity.Users;
import com.database.fitnessTracker.repository.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Getter
@RequiredArgsConstructor
public class UserService {

    private final Log logger = LogFactory.getLog(this.getClass());


    private final UserRepository userRepository;
    public void save(Users user) {
        userRepository.save(user);
    }

    public Optional<Users> findById(Integer id) {
        return userRepository.findById(id);
    }

    public Iterable<Users> findAll() {
        return userRepository.findAll();
   }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

    public void update(Users user) {
        userRepository.save(user);
    }

    public Optional<Users> findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public boolean makeAdmin(Integer id) {
        return makeAdmin(userRepository.findById(id).orElseThrow(UnknownUserException::new).getId());
    }

    public boolean makeAdmin(Users user) {
        if (user.getRole().toString().equalsIgnoreCase("ADMIN")) {
            logger.warn("Unknown error: " + user.getRole().toString() + " not equals to 'user'");
            return false;
        }
        else {
            userRepository.changeToAdmin(user.getId());
            return true;
        }
    }

    public boolean makeUser(Integer id) {
        return makeUser(userRepository.findById(id).orElseThrow(UnknownUserException::new).getId());
    }

    public boolean makeUser(Users user) {
        if (user.getRole().toString().equalsIgnoreCase("USER")) {
            logger.warn("Unknown error: " + user.getRole().toString() + " not equals to 'user'");
            return false;
        }
        else {
            userRepository.changeToUser(user.getId());
            return true;
        }
    }
}
