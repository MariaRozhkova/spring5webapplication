package guru.springframework.spring5webapplication.config;

import guru.springframework.spring5webapplication.repositories.GreetingRepository;
import guru.springframework.spring5webapplication.services.GreetingService;
import guru.springframework.spring5webapplication.services.impl.GreetingServiceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingConfiguration {

    @Bean
    public GreetingServiceFactory greetingServiceFactory(final GreetingRepository greetingRepository) {
        return new GreetingServiceFactory(greetingRepository);
    }

    @Bean
    @Profile({"EN", "default"})
    public GreetingService englishGreetingService(final GreetingServiceFactory greetingServiceFactory) {
        return greetingServiceFactory.createGreetingService("en");
    }

    @Bean
    @Profile("DE")
    @Primary
    public GreetingService germanGreetingService(final GreetingServiceFactory greetingServiceFactory) {
        return greetingServiceFactory.createGreetingService("de");
    }

    @Bean
    @Profile("SP")
    public GreetingService spanishGreetingService(final GreetingServiceFactory greetingServiceFactory) {
        return greetingServiceFactory.createGreetingService("sp");
    }
}
