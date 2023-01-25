package br.com.denilo.ticketmanagementsystem.configuration;

import br.com.denilo.ticketmanagementsystem.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
@org.springframework.context.annotation.Profile("dev")
public class DevConfiguration  {

    @Autowired
    private DBService dbService;

    @Bean
    public void initializeDB() {
        this.dbService.initializeDB();
    }
}
