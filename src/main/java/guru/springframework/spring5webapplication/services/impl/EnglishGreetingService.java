package guru.springframework.spring5webapplication.services.impl;

import guru.springframework.spring5webapplication.repositories.GreetingRepository;
import guru.springframework.spring5webapplication.services.GreetingService;

public class EnglishGreetingService implements GreetingService {

    private final GreetingRepository greetingRepository;

    public EnglishGreetingService(final GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public String sayHello() {
        return greetingRepository.createEnglishGreeting();
    }
}
