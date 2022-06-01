package com.senac.domain.output;

import com.senac.domain.enums.ContactTypeEn;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ContactOut {
    private ContactTypeEn contactTypeEn;
    private String number;
}
