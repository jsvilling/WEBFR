package ch.fhnw.webfr.flashcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlashcardApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlashcardApplication.class);
    }

    // @Bean
    // public ValidatingMongoEventListener validatingMongoEventListener() {
    //     return new ValidatingMongoEventListener(validator());
    // }

    // @Bean
    // public LocalValidatorFactoryBean validator() {
    //     return new LocalValidatorFactoryBean();
    // }
}