package com.eco_lab.eco_lab.Service;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

@Service
public class GoogleDriveService {

    private final Drive driveService;

    public GoogleDriveService() throws GeneralSecurityException, IOException {
        GoogleCredential credential = GoogleCredential.fromStream(
                        new FileInputStream("src/main/resources/ecolab-468112-5f8b790716ee.json"))
                .createScoped(Collections.singleton(DriveScopes.DRIVE_FILE));
        this.driveService = new Drive.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                GsonFactory.getDefaultInstance(),
                credential)
                .setApplicationName("Ecolab")
                .build();
    }

    public String uploadFile() throws IOException {
        File fileMetadata = new File();
        fileMetadata.setName("myfile.txt"); // set your file name

        java.io.File filePath = new java.io.File("local/path/myfile.txt");
        FileContent mediaContent = new FileContent("text/plain", filePath);

        File uploadedFile = driveService.files().create(fileMetadata, mediaContent)
                .setFields("id")
                .execute();

        System.out.println("File ID: " + uploadedFile.getId());
        return uploadedFile.getId();
    }
}
