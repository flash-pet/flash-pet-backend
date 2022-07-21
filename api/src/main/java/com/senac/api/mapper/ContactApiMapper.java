//package com.senac.api.mapper;
//
//import com.senac.api.dto.Contact;
//import com.senac.domain.enums.ContactTypeEn;
//import com.senac.domain.input.ContactInp;
//import com.senac.domain.output.ContactOut;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class ContactApiMapper {
//    private ContactApiMapper(){}
//
//    public static final List<ContactInp> toDomain(List<Contact> contacts) {
//        if(contacts == null) return null;
//        return contacts.stream()
//                .map(contact -> convertDomain(contact))
//                .collect(Collectors.toList());
//    }
//
//    public static final List<Contact> toResponse(List<ContactOut> contacts) {
//        if(contacts == null) return null;
//        return contacts.stream()
//                .map(contact -> convertResponse(contact))
//                .collect(Collectors.toList());
//    }
//
//    private static final ContactInp convertDomain(Contact contact) {
//        return ContactInp.builder()
//                .number(contact.getNumber())
//                .contactTypeEn(ContactTypeEn.valueOf(contact.getContactType().toString().toUpperCase()))
//                .build();
//    }
//
//    private static final Contact convertResponse(ContactOut contact) {
//            final Contact contactResponse = new Contact();
//            contactResponse.setContactType(contact.getContactTypeEn().toString().toLowerCase());
//            contactResponse.setNumber(contact.getNumber());
//            return contactResponse;
//    }
//}
