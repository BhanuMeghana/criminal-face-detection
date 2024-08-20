package com.criminalfacedetection.service;

import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.BlobStorageException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class AzureBlobService {

    @Value("${azure.storage.connection-string}")
    private String connectionString;

    @Value("${azure.storage.container-name}")
    private String containerName;

    private BlobServiceClient getBlobServiceClient() {
        return new BlobServiceClientBuilder().connectionString(connectionString).buildClient();
    }

    public String uploadFile(MultipartFile file) throws IOException {
        BlobServiceClient blobServiceClient = getBlobServiceClient();
        String fileName = file.getOriginalFilename();
        try (InputStream inputStream = file.getInputStream()) {
            blobServiceClient.getBlobContainerClient(containerName)
                    .getBlobClient(fileName)
                    .upload(inputStream, file.getSize(), true);
        }
        return "https://<your-storage-account-name>.blob.core.windows.net/" + containerName + "/" + fileName;
    }
}
