package com.senac.commons.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ServiceType {
    BATH_SHEAR("https://flash-pet-images.s3.amazonaws.com/default/BANHO+E+TOZA.png"),
    VACCINATE("https://flash-pet-images.s3.amazonaws.com/default/VACINA.png"),
    MEDICAL_CONSULTATION("https://flash-pet-images.s3.amazonaws.com/default/CONSULTA.jpg"),
    SURGERY("https://flash-pet-images.s3.amazonaws.com/default/CIRURGIA.jpg"),
    HOST("https://flash-pet-images.s3.amazonaws.com/default/HOTEL.jpg");

    private String imageUrl;
}
