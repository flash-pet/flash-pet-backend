package com.senac.commons.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum S3Path {
    LOGO("logos/"),
    CARROSEL("carrosel/");

    private String path;
}
