package br.com.denilo.callmanagementsystem.configuration;

import br.com.denilo.callmanagementsystem.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
@org.springframework.context.annotation.Profile("test")
public class TestConfiguration {

    @Autowired
    private DBService dbService;

    @Bean
    public void initializeDB() {
        this.dbService.initializeDB();
    }

}
