package com.senac.service.utils;


import com.senac.service.exception.ImageConverterException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Base64;
import java.util.UUID;

public class ImageUtils {
    private ImageUtils(){}

    public static final File convertBase64ToFile(String imageBase64) {
        final String[] base64Parts = imageBase64.split(",");
        final byte[] image = Base64.getDecoder().decode(base64Parts[1]);
        try {
            final BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(image));

            final String imageName = UUID.randomUUID().toString();
            final String extension = getExtension(base64Parts[0]);

            final File outputfile = new File(imageName.concat(".").concat(extension));

            ImageIO.write(bufferedImage, extension, outputfile);

            return outputfile;
        } catch (Exception e) {
            throw new ImageConverterException("Erro to convert image base 64", e);
        }
    }

    private static String getExtension(String base64) {
        switch (base64) {
            case "data:image/jpeg;base64":
                return "jpeg";
            case "data:image/png;base64":
                return "png";
            default:
                return  "jpg";
        }
    }
}
