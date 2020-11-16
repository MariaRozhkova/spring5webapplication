package guru.springframework.spring5webapplication.services.impl;

import guru.springframework.spring5webapplication.services.GreetingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"EN", "default"})
@Service(value = "i18Service")
public class EnglishGreetingService implements GreetingService {
    @Override
    public String sayHello() {
        return "Say hello - English";
    }
}
