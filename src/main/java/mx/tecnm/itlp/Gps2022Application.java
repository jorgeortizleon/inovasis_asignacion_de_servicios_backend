package mx.tecnm.itlp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication 
@EntityScan(basePackages = "mx.tecnm.itlp.models")
@EnableJpaRepositories(basePackages = "mx.tecnm.itlp.respository")

public class Gps2022Application {

	public static void main(String[] args) {
		SpringApplication.run(Gps2022Application.class, args);
	}
	
	// Agrega esta configuración para habilitar CORS globalmente
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:8080") // Cambia esto si tu frontend se ejecuta en otro puerto o dominio
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*");
            }
        };
    }

}
