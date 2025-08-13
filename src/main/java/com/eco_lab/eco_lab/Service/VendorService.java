package com.eco_lab.eco_lab.Service;

import com.eco_lab.eco_lab.Entity.User;
import com.eco_lab.eco_lab.Entity.Vendor;
import com.eco_lab.eco_lab.Repository.UserRepository;
import com.eco_lab.eco_lab.Repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<String> addVendor(Vendor vendorData) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();

        User byUsername = userRepository.findByUsername(name);

        Vendor save = vendorRepository.save(vendorData);
        String jsonResponse = String.format(
                "{\"message\": \"Vendor added with the email\", \"emailId\": \"%s\"}",
                save.getRequestorEmail()
        );

        byUsername.setVendor(save);
        userRepository.save(byUsername);

        return ResponseEntity.status(HttpStatus.CREATED).body(jsonResponse);
    }
}

