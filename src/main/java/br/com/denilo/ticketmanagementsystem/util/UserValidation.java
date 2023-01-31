package br.com.denilo.ticketmanagementsystem.util;

import br.com.denilo.ticketmanagementsystem.repositories.UserRepository;
import br.com.denilo.ticketmanagementsystem.services.exceptions.UserAlreadyExistsException;
import org.springframework.stereotype.Component;

@Component
public class UserValidation {

    private static UserRepository userRepository;

    public UserValidation(UserRepository userRepository) {
        UserValidation.userRepository = userRepository;
    }

    public static void userValidation(String cpf, String email) {
        if (userRepository.findByCpf(cpf).isPresent()) {
            throw new UserAlreadyExistsException("User with CPF already registered.");
        } else if (userRepository.findByEmail(email).isPresent()) {
            throw new UserAlreadyExistsException("User with e-mail already registered.");
        }
    }

}


