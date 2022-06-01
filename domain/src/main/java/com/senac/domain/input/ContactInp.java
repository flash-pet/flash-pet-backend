package com.senac.domain.input;

import com.senac.domain.enums.ContactTypeEn;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ContactInp {
    private ContactTypeEn contactTypeEn;
    private String number;
}
