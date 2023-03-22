package br.com.denilo.ticketmanagementsystem.services;

import br.com.denilo.ticketmanagementsystem.entities.User;
import br.com.denilo.ticketmanagementsystem.repositories.UserRepository;
import br.com.denilo.ticketmanagementsystem.security.UserSS;
import br.com.denilo.ticketmanagementsystem.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            return new UserSS(
                    user.get().getId(),
                    user.get().getEmail(),
                    user.get().getPassword(),
                    user.get().getProfiles()
            );
        }
        throw new UsernameNotFoundException(email);
    }

}
