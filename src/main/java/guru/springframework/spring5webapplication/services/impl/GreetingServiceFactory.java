package guru.springframework.spring5webapplication.services.impl;

import guru.springframework.spring5webapplication.repositories.GreetingRepository;
import guru.springframework.spring5webapplication.services.GreetingService;

public class GreetingServiceFactory {

    private final GreetingRepository greetingRepository;

    public GreetingServiceFactory(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public GreetingService createGreetingService(final String lang) {
        switch (lang) {
            case "en":
                return new EnglishGreetingService(greetingRepository);
            case "sp":
                return new SpanishGreetingService(greetingRepository);
            case "de":
                return new GermanGreetingService(greetingRepository);
            default:
                return new EnglishGreetingService(greetingRepository);
        }
    }
}
