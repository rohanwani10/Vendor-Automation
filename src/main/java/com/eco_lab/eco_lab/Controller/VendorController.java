package com.eco_lab.eco_lab.Controller;


import com.eco_lab.eco_lab.Entity.Vendor;
import com.eco_lab.eco_lab.Service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendor")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @PostMapping
    public ResponseEntity<String> addVendor(@RequestBody Vendor vendorData){
        return vendorService.addVendor(vendorData);

    }

    @GetMapping("/test")
    public String test(){
        return "Test With Jwt";
    }

}
