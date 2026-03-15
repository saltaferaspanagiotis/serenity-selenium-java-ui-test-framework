package demo.bdd.configuration;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
@EnableEncryptableProperties
@Data
public class TestConfig {
    private String homePageUrl;
    private String homePageTitle;
    private String pizzaHouseUrl;
    private Users users;

    @Data
    public static class Users {
        private User validUser;
        private User invalidUsername;
        private User invalidPassword;
    }

    @Data
    public static class User {
        private String username;
        private String password;
    }
}
