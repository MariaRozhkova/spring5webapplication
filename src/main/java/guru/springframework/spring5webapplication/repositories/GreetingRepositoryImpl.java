package guru.springframework.spring5webapplication.repositories;

import org.springframework.stereotype.Component;

@Component
public class GreetingRepositoryImpl implements GreetingRepository {

    @Override
    public String createEnglishGreeting() {
        return "Say Hello - English";
    }

    @Override
    public String createSpanishGreeting() {
        return "Say Hello - Spanish";
    }

    @Override
    public String createGermanGreeting() {
        return "Say Hello - German";
    }
}
