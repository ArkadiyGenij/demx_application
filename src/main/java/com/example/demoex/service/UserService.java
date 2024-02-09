package com.example.demoex.service;

import com.example.demoex.model.User;
import com.example.demoex.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public List<User> findAll(){
        return userRepo.findAll();
    }

    public void save(User user){
        user.setName(user.getName());
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());
        userRepo.save(user);
    }

    public void deleteUser(Long id){
        this.userRepo.deleteById(id);
    }

    /** Метод для получения пользователя по ID
     * Используем лямба-выражение чтобы создать исключение в случае если пользователя в БД не окажется
     */

    public User getUserById(Long id){
        return userRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
    }

    public List<User> findUserByName(String name){
        return userRepo.findByNameContainingIgnoreCase(name);
    }
}
