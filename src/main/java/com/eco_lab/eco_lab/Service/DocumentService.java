package com.eco_lab.eco_lab.Service;

import com.eco_lab.eco_lab.Entity.User;
import com.eco_lab.eco_lab.Entity.Vendor_Document;
import com.eco_lab.eco_lab.Repository.DocumentRepository;
import com.eco_lab.eco_lab.Repository.UserRepository;
import com.eco_lab.eco_lab.Repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VendorRepository vendorRepository;

    public ResponseEntity<String> uploadDoc(MultipartFile file) throws IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User currentUser = userRepository.findByUsername(username);

        Vendor_Document document = new Vendor_Document();
        document.setFilename(file.getOriginalFilename());
        document.setType(file.getContentType());
        document.setContent(file.getBytes());

        Vendor_Document savedDoc = documentRepository.save(document);

        currentUser.setVendorDocument(document);

        userRepository.save(currentUser);

        return ResponseEntity.ok("{\"message\": \"Files added successfully " + savedDoc.getFilename() + "\"}");
    }
}
