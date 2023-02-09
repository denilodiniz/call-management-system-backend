package br.com.denilo.ticketmanagementsystem.services.util;

import br.com.denilo.ticketmanagementsystem.entities.User;
import br.com.denilo.ticketmanagementsystem.repositories.UserRepository;
import br.com.denilo.ticketmanagementsystem.services.exceptions.UserAlreadyExistsException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserValidation {

    private static UserRepository userRepository;

    public UserValidation(UserRepository userRepository) {
        UserValidation.userRepository = userRepository;
    }

    public static void userValidationForUserExist(String cpf, String email) {
        if (userRepository.findByCpf(cpf).isPresent()) {
            throw new UserAlreadyExistsException("User with CPF already registered.");
        }
        if (userRepository.findByEmail(email).isPresent()) {
            throw new UserAlreadyExistsException("User with e-mail already registered.");
        }
    }

    public static void userValidationForUserUpdate(Long id, String cpf, String email) {
        Optional<User> byCpf = userRepository.findByCpf(cpf);
        if (byCpf.isPresent()) {
            Long idUser = byCpf.get().getId();
            if (!id.equals(idUser)) {
                throw new UserAlreadyExistsException("User with CPF already registered.");
            }
        }
        Optional<User> byEmail = userRepository.findByEmail(email);
        if (byEmail.isPresent()) {
            Long idUser = byEmail.get().getId();
            if (!id.equals(idUser)) {
                throw new UserAlreadyExistsException("User with e-mail already registered.");
            }
        }
    }

}


