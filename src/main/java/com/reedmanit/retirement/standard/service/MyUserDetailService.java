package com.reedmanit.retirement.standard.service;

import com.reedmanit.retirement.standard.data.MyUser;

//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    private final MyUserRepository myUserRepository;

    // Constructor injection for MyUserRepository
    public MyUserDetailService(MyUserRepository myUserRepository) {
        this.myUserRepository = myUserRepository;
    }

    /**
     * Loads the user by username.
     *
     * @param username the username to search for
     * @return the UserDetails object
     * @throws UsernameNotFoundException if the username is not found
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Add debug logging
        System.out.println("Attempting to load user: " + username);

        Optional<MyUser> myUserOptional = myUserRepository.findByUsername(username);
        if (myUserOptional.isPresent()) {
            MyUser myUser = myUserOptional.get();

            // Add more debug logging
            System.out.println("User loaded successfully: " + username);


            return org.springframework.security.core.userdetails.User.builder()
                    .username(myUser.getUsername())
                    .password(myUser.getPassword())
                    .roles(myUser.getRoles().split(","))
                    .build();



        } else {
            throw new UsernameNotFoundException(username);
        }
    }
}
