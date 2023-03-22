package com.example.springboot.quotes;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuotesConfig {

    @Bean
    CommandLineRunner commandLineRunner(QuotesRepository repository) {
        return args -> {    
            Quotes oscarWilde = new Quotes(
                "Oscar Wild",
                  "To be or not to be"
                  );
                Quotes marieCurie =  new Quotes(
                "Marie Curie",
                  "Nothing in life is to be feared; it is only to be understood."
                  );
                  Quotes donaldDuck =  new Quotes(
                "Donald Duck",
                  "discover dkjfh kds k"
                  );

            repository.saveAll(List.of(oscarWilde,marieCurie,donaldDuck)); 

        };
    }
}
