package com.sportyshoes.service;

import com.sportyshoes.entity.UserEntity;
import com.sportyshoes.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;

    @Transactional
    public List<UserEntity> findAll() {
        return repository.findAll();
    }

    public UserEntity save(UserEntity user) {
        return repository.save(user);
    }

    @Transactional
    public Optional<UserEntity> findById(Integer userId) {
        return repository.findById(userId);
    }

    @Transactional
    public Optional<UserEntity> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public List<UserEntity> saveAll(List users) {
        return repository.saveAll(users);
    }

    public void deleteById(Integer userId) {
        repository.deleteById(userId);
    }

    public void delete(UserEntity user) {
        repository.delete(user);
    }
}
