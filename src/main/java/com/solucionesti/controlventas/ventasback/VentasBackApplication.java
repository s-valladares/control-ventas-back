package com.solucionesti.controlventas.ventasback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class VentasBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(VentasBackApplication.class, args);
    }

}
