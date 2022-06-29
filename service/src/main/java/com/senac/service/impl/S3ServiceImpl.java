package com.senac.service.impl;

import com.senac.infrastructure.repository.S3Repository;
import com.senac.service.S3Service;
import com.senac.service.config.ServiceProperties;
import com.senac.service.enums.S3Path;
import com.senac.service.utils.ImageUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class S3ServiceImpl implements S3Service {

    private final S3Repository s3Repository;

    private final ServiceProperties serviceProperties;

    @Override
    public String saveImage(String image, S3Path s3Path) {
        return s3Repository.putObject(serviceProperties.getBucketName(),
                s3Path.getPath(),
                ImageUtils.convertBase64ToFile(image));
    }

    @Override
    public void deleteImage(String url, S3Path s3Path) {
        final String[] urlParts = url.split("/");
        final int index = urlParts.length - 1;
        s3Repository.deleteObject(serviceProperties.getBucketName(), s3Path.getPath().concat(urlParts[index]));
    }
}
