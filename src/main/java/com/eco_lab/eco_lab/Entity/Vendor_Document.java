package com.eco_lab.eco_lab.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Vendor_Document")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Vendor_Document {

    @Id
    private String id;
    private String email;
    private String filename;
    private String type;
    private byte[] content;

    @DBRef
    private Vendor vendor;
}
