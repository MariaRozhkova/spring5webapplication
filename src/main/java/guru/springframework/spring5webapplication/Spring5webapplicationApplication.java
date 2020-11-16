package guru.springframework.spring5webapplication;

import guru.springframework.spring5webapplication.controllers.I18nController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Spring5webapplicationApplication {

    public static void main(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(Spring5webapplicationApplication.class, args);

        final I18nController controller = (I18nController) context.getBean("i18nController");
        System.out.println(controller.sayHello());
    }

}
