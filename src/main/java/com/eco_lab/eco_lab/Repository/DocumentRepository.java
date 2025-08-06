package com.eco_lab.eco_lab.Repository;

import com.eco_lab.eco_lab.Entity.Vendor_Document;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DocumentRepository extends MongoRepository<Vendor_Document, String> {
}
