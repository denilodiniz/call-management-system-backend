package br.com.denilo.ticketmanagementsystem.util;

import br.com.denilo.ticketmanagementsystem.repositories.UserRepository;
import br.com.denilo.ticketmanagementsystem.services.exceptions.RequiredFieldException;
import br.com.denilo.ticketmanagementsystem.services.exceptions.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
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
        }
        else if (userRepository.findByEmail(email).isPresent()) {
            throw new UserAlreadyExistsException("User with e-mail already registered.");
        }
    }

    public static void requiredField(String name, String cpf, String email, String password) {
        StringBuilder sb = new StringBuilder();
        if (name == null || cpf == null || email == null || password == null) {
            if (name == null) {
                sb.append(" name");
            }
            if (cpf == null) {
                sb.append(" CPF");
            }
            if (email == null) {
                sb.append(" e-mail");
            }
            if (password == null) {
                sb.append(" password");
            }
            throw new RequiredFieldException("Field" + sb.toString() + " is null.");
        }
    }

}


