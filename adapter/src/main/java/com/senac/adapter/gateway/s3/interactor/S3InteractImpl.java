package com.senac.adapter.gateway.s3.interactor;

import com.senac.adapter.config.AdapterProperties;
import com.senac.adapter.gateway.s3.S3Gateway;
import com.senac.adapter.utils.ImageUtils;
import com.senac.commons.enums.S3Path;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class S3InteractImpl implements S3Interact {

    private final S3Gateway s3Repository;

    private final AdapterProperties serviceProperties;

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
