package com.eco_lab.eco_lab.Repository;

import com.eco_lab.eco_lab.Entity.Vendor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VendorRepository extends MongoRepository<Vendor, String> {
    Vendor findVendorByrequestorEmail(String email);
}
