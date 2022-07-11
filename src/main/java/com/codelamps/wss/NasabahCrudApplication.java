package com.codelamps.wss;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Nama : Andre Rizaldi Brillianto
 * Project : nasabah-webservice-app
 * Email: andrerizaldib@gmail.com
 * Date: 8/07/22
 */
@SpringBootApplication
public class NasabahCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(NasabahCrudApplication.class, args);
    }

}
