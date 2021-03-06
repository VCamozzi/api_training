package fr.esiea.ex4A;

import fr.esiea.ex4A.Agify.Agify;
import fr.esiea.ex4A.Agify.AgifyClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

@SpringBootApplication
public class Launcher {

    @Bean
    AgifyClient createAgifyClient() throws IOException {
        AgifyClient client = new Retrofit.Builder()
            .baseUrl("http://api.agify.io")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
            .create(AgifyClient.class);

        return client;
    }

    public static void main(String[] args) {
        SpringApplication.run(Launcher.class, args);
    }
}
