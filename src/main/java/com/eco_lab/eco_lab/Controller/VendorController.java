package com.eco_lab.eco_lab.Controller;


import com.eco_lab.eco_lab.Entity.Vendor;
import com.eco_lab.eco_lab.Service.DocumentService;
import com.eco_lab.eco_lab.Service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/vendor")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @Autowired
    private DocumentService documentService;

    @PostMapping
    public ResponseEntity<String> addVendor(@RequestBody Vendor vendorData) {
        return vendorService.addVendor(vendorData);
    }


    @PostMapping("/upload")
    public ResponseEntity<String> uploadDocument(@RequestParam("file") MultipartFile file) throws IOException {
        return documentService.uploadDoc(file);
    }


    @GetMapping("/test")
    public String test() {
        return "Test With Jwt";
    }

}
