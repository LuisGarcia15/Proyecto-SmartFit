package com.project.smartfit.implementations;

import com.project.smartfit.dto.SaveUser;
import com.project.smartfit.entities.Client;
import com.project.smartfit.entities.ClientAddress;
import com.project.smartfit.repositories.ClientAddressRepository;
import com.project.smartfit.services.ClientAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientAddressServiceImp implements ClientAddressService {

    @Autowired
    private ClientAddressRepository clientAddressRepository;

    @Override
    public ClientAddress registerOneRegister(SaveUser newUser, Client client) {
        ClientAddress clientAddress = new ClientAddress();

        clientAddress.setIdClient(client);
        clientAddress.setName(newUser.getClientAddress().getName());
        clientAddress.setOuterNumber(newUser.getClientAddress().getOuterNumber());
        clientAddress.setInsideNumber(newUser.getClientAddress().getInsideNumber());
        clientAddress.setState(newUser.getClientAddress().getState());
        clientAddress.setCity(newUser.getClientAddress().getCity());

        return this.clientAddressRepository.save(clientAddress);
    }
}
