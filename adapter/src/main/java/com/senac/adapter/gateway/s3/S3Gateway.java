package com.senac.adapter.gateway.s3;


import java.io.File;

public interface S3Gateway {
    String putObject(String bucketName, String path, File file);
    void deleteObject(String bucketName, String key);
}
