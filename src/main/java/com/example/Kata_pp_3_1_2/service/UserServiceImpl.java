package com.example.Kata_pp_3_1_2.service;

import com.example.Kata_pp_3_1_2.model.User;
import com.example.Kata_pp_3_1_2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User show(long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void update(long id, User updatedUser) {
        updatedUser.setId(id);
        userRepository.save(updatedUser);
    }

    @Transactional
    @Override
    public void remove(long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public void create10users() {
        for (int i = 0; i < 10; i++) {
            User user = new User("temp", 33, "temp@temp.temp");
            userRepository.save(user);
            user.setName("Хуман" + user.getId());
            user.setEmail("test" + user.getId() + "@mail.org");
        }
    }

}
