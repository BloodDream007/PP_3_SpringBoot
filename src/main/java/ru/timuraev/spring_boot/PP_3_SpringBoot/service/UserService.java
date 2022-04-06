package ru.timuraev.spring_boot.PP_3_SpringBoot.service;

import org.springframework.stereotype.Service;
import ru.timuraev.spring_boot.PP_3_SpringBoot.model.User;
import ru.timuraev.spring_boot.PP_3_SpringBoot.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByID(Long id){
        return userRepository.findById(id).orElse(null); // Optional<T>
//        return userRepository.getOne(id); // getOne() - DEPRECATED Method
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteByID(Long id){
        userRepository.deleteById(id);
    }

    public void update(User user){
        userRepository.saveAndFlush(user);
    }
}
