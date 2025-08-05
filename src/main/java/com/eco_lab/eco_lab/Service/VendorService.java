package com.eco_lab.eco_lab.Service;

import com.eco_lab.eco_lab.Entity.Vendor;
import com.eco_lab.eco_lab.Repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    public ResponseEntity<String> addVendor(Vendor vendorData) {
        Vendor save = vendorRepository.save(vendorData);
        return ResponseEntity.status(HttpStatus.CREATED).body("Vendor added with the email: " + save.getRequestorEmail());
    }
}
