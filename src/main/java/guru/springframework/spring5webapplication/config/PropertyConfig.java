package guru.springframework.spring5webapplication.config;

import guru.springframework.spring5webapplication.datasource.FakeDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:datasource.properties")
public class PropertyConfig {

    @Value("${guru.username}")
    private String username;
    @Value("${guru.password}")
    private String password;
    @Value("${guru.dburl}")
    private String url;

    @Bean
    public FakeDataSource fakeDataSource() {
        final FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(url);
        return fakeDataSource;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}