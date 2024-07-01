package com.project.smartfit.implementations;

import com.project.smartfit.dto.SaveUser;
import com.project.smartfit.entities.*;
import com.project.smartfit.repositories.*;
import com.project.smartfit.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImp implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client registerOneRegister(SaveUser newUser) {
        Client client = new Client();

        client.setName(newUser.getClient().getName());
        client.setPaternalSurname(newUser.getClient().getPaternalSurname());
        client.setMaternalSurname(newUser.getClient().getMaternalSurname());
        client.setCurp(newUser.getClient().getCurp());
        client.setPhoneNumber(newUser.getClient().getPhoneNumber());
        client.setEmail(newUser.getClient().getEmail());
        return this.clientRepository.save(client);

    }
}
