package com.senac.infrastructure.repository;


import java.io.File;

public interface S3Repository {
    String putObject(String bucketName, String path, File file);
    void deleteObject(String bucketName, String key);
}
