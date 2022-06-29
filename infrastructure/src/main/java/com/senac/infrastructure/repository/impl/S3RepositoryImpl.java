package com.senac.infrastructure.repository.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.senac.infrastructure.repository.S3Repository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
@AllArgsConstructor
public class S3RepositoryImpl implements S3Repository {

    private final AmazonS3 amazonS3;

    @Override
    public String putObject(String bucketName, String path, File file) {
        final String filePath = path.concat(file.getName());
        final AmazonS3Client client = (AmazonS3Client) amazonS3;
        client.putObject(bucketName, filePath, file);
        file.delete();
        return client.getResourceUrl(bucketName, filePath);
    }

    @Override
    public void deleteObject(String bucketName, String key) {
        final AmazonS3Client client = (AmazonS3Client) amazonS3;
        client.deleteObject(bucketName, key);
    }
}
