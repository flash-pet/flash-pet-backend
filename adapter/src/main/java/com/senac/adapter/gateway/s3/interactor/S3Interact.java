package com.senac.adapter.gateway.s3.interactor;


import com.senac.commons.enums.S3Path;

public interface S3Interact {
    public String saveImage(String image, S3Path s3Path);
    void deleteImage(String url, S3Path s3Path);
}
