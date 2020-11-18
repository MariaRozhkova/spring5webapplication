package guru.springframework.spring5webapplication.services.impl;

import guru.springframework.spring5webapplication.repositories.GreetingRepository;
import guru.springframework.spring5webapplication.services.GreetingService;

public class SpanishGreetingService implements GreetingService {

    private final GreetingRepository greetingRepository;

    public SpanishGreetingService(final GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public String sayHello() {
        return greetingRepository.createSpanishGreeting();
    }
}
