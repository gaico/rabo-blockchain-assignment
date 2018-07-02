package nl.gst.rabo.blockbliek;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileNotFoundException;

@Configuration
public class BlockBliekConfig {
    @Bean
    public UserRepository userRepository() throws FileNotFoundException {
        return new UserRepository();
    }

    @Bean
    public BlockBliekService blockBliekService() {
        return new BlockBliekService();
    }

    @Bean
    public UserService userService() throws FileNotFoundException{
        return new UserService(userRepository(), blockBliekService());
    }
}
