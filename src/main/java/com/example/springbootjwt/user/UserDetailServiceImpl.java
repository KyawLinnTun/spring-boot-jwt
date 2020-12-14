package com.example.springbootjwt.user;

import com.example.springbootjwt.repository.ApplicationUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailServiceImpl implements UserDetailsService {


    private ApplicationUserRepository applicationUserRepository;

    public UserDetailServiceImpl(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserffByUsername(String username) throws UsernameNotFoundException {

        ApplicationUser appUser = applicationUserRepository.findByUsername(username);
        if (appUser == null) {
            throw new UsernameNotFoundException("Not Found" + username);
        }

        return new User(appUser.getUsername(), appUser.getPassword(), Collections.emptyList());
    }

}
