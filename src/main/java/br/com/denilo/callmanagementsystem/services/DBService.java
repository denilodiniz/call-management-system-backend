package br.com.denilo.callmanagementsystem.services;

import br.com.denilo.callmanagementsystem.entities.Called;
import br.com.denilo.callmanagementsystem.entities.Client;
import br.com.denilo.callmanagementsystem.entities.Technician;
import br.com.denilo.callmanagementsystem.entities.enums.Priority;
import br.com.denilo.callmanagementsystem.entities.enums.Profile;
import br.com.denilo.callmanagementsystem.repositories.CalledRepository;
import br.com.denilo.callmanagementsystem.repositories.ClientRepository;
import br.com.denilo.callmanagementsystem.repositories.TechnicianRepository;
import br.com.denilo.callmanagementsystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private TechnicianRepository technicianRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CalledRepository calledRepository;

    public void initializeDB() {
        Client client = new Client(
                "Linus Torvalds", "70511744013", "linus@email.com", "123"
        );

        Technician technician = new Technician(
                "Valdir Cezar", "76045777093", "valdir@email.com", "123"
        );
        technician.addProfile(Profile.ADMIN);

        Called called = new Called(
                "Chamado 01", "Primeiro chamado.", Priority.MEDIUM, client, technician
        );

        clientRepository.save(client);
        technicianRepository.save(technician);
        calledRepository.save(called);
    }

}
