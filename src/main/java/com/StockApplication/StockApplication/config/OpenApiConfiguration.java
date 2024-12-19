package com.StockApplication.StockApplication.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        server.setUrl("http://localhost:8081");
        server.setDescription("Development");

        // Define the contact information
        Contact myContact = new Contact();
        myContact.setName("Sagar Chaudhary");
        myContact.setEmail("sagar1.chaudhary@paytm.com");

        // Define the OpenAPI information
        Info information = new Info()
                .title("Stock Application User_Service API")
                .version("1.0")
                .description("This API exposes endpoints to manage User.")
                .contact(myContact);

        // Return OpenAPI configuration with the server and information
        return new OpenAPI().info(information).servers(List.of(server));
    }
}

