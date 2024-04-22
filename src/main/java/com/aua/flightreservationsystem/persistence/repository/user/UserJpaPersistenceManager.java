package com.aua.flightreservationsystem.persistence.repository.user;

import com.aua.flightreservationsystem.core.user.User;
import com.aua.flightreservationsystem.core.user.UserPersistenceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserJpaPersistenceManager implements UserPersistenceManager {
    private final UserRepository customerRepository;

    private final UserEntityMapper customerEntityMapper;

    @Autowired
    public UserJpaPersistenceManager(UserRepository customerRepository, UserEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }


    @Override
    public List<User> findAllCustomers() {
        return customerRepository.findAll().stream().map(customerEntityMapper::map).toList();
    }

    @Override
    public Optional<User> findById(Long id) {
        return customerRepository.findById(id).map(customerEntityMapper::map);
    }


    @Override
    public User saveCustomer(User customer) {
        return customerEntityMapper.map(customerRepository.save(customerEntityMapper.map(customer)));
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }
}
