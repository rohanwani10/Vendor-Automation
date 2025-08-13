package com.eco_lab.eco_lab.Service;

import com.eco_lab.eco_lab.Entity.User;
import com.eco_lab.eco_lab.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AutomationService {

    @Autowired
    private UserRepository userRepository;

    public User findUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return userRepository.findByUsername(username);
    }

    public User getVendorUser(String email) {
        User byEmail = userRepository.findByEmail(email);
        return byEmail;
    }
}
