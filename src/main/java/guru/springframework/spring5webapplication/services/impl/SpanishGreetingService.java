package guru.springframework.spring5webapplication.services.impl;

import guru.springframework.spring5webapplication.services.GreetingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("SP")
@Service(value = "i18Service")
public class SpanishGreetingService implements GreetingService {
    @Override
    public String sayHello() {
        return "Hello world - Spanish";
    }
}
