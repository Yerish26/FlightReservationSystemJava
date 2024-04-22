package com.aua.flightreservationsystem.persistence.repository.user;

import com.aua.flightreservationsystem.core.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserJpaPersistenceManager implements UserPersistenceManager {
    private final UserRepository userRepository;

    private final UserEntityMapper userEntityMapper;

    @Autowired
    public UserJpaPersistenceManager(UserRepository userRepository, UserEntityMapper customerEntityMapper) {
        this.userRepository = userRepository;
        this.userEntityMapper = customerEntityMapper;
    }


    @Override
    public List<User> findAllCustomers() {
        return userRepository.findAll().stream().map(userEntityMapper::map).toList();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id).map(userEntityMapper::map);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username).map(userEntityMapper::map);
    }


    @Override
    public User save(User customer) {
        return userEntityMapper.map(userRepository.save(userEntityMapper.map(customer)));
    }

    @Override
    public void deleteCustomer(Long customerId) {
        userRepository.deleteById(customerId);
    }
}
