package com.senac.service.mapper;

import com.senac.domain.enums.ContactTypeEn;
import com.senac.domain.input.ContactInp;
import com.senac.domain.output.ContactOut;
import com.senac.infrastructure.entity.Contact;
import com.senac.infrastructure.enums.ContactType;

import java.util.List;
import java.util.stream.Collectors;

public class ContactMapper {
    private ContactMapper(){}

    public static final List<Contact> toEntity(List<ContactInp> contactInps) {
        if(contactInps == null) return null;
        return contactInps.stream()
                .map(contact -> convertEntity(contact))
                .collect(Collectors.toList());
    }

    public static final List<ContactOut> toOut(List<Contact> contacts) {
        if(contacts == null) return null;
        return contacts.stream()
                .map(contact -> convertOut(contact))
                .collect(Collectors.toList());
    }

    private static final Contact convertEntity(ContactInp contactInp) {
        return Contact.builder()
                .number(contactInp.getNumber())
                .contactType(ContactType.valueOf(contactInp.getContactTypeEn().toString().toUpperCase()))
                .build();
    }

    private static final ContactOut convertOut(Contact contact) {
        return ContactOut.builder()
                .number(contact.getNumber())
                .contactTypeEn(ContactTypeEn.valueOf(contact.getContactType().toString().toUpperCase()))
                .build();
    }
}
