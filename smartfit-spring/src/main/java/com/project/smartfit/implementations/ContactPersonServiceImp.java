package com.project.smartfit.implementations;

import com.project.smartfit.dto.SaveUser;
import com.project.smartfit.entities.Client;
import com.project.smartfit.entities.ContactPerson;
import com.project.smartfit.repositories.ContactPersonRepository;
import com.project.smartfit.services.ContactPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactPersonServiceImp implements ContactPersonService {

    @Autowired
    private ContactPersonRepository contactPersonRepository;

    @Override
    public ContactPerson registerOneRegister(SaveUser newUser, Client client) {
        ContactPerson contactPerson = new ContactPerson();

        contactPerson.setIdClient(client);
        contactPerson.setName(newUser.getContactPerson().getName());
        contactPerson.setPaternalSurname(newUser.getContactPerson().getPaternalSurname());
        contactPerson.setMaternalSurname(newUser.getContactPerson().getMaternalSurname());
        contactPerson.setPhoneNumber(newUser.getContactPerson().getPhoneNumber());

        return this.contactPersonRepository.save(contactPerson);
    }
}
