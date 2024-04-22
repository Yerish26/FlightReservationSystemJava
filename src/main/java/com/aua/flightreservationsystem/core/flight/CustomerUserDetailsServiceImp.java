package com.aua.flightreservationsystem.core.flight;

import com.aua.flightreservationsystem.persistence.repository.CustomerRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomerUserDetailsServiceImp implements UserDetailsService {
    private final CustomerRepository customerRepository;

    public CustomerUserDetailsServiceImp(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return customerRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
