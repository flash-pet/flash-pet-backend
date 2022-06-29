package com.senac.service;

import com.senac.service.enums.S3Path;

public interface S3Service {
    public String saveImage(String image, S3Path s3Path);
    void deleteImage(String url, S3Path s3Path);
}
