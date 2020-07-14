package hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfiguration {

    @Bean
//    @Scope("prototype")
    public AppService appService(){
        System.out.println("ewew-----===");
        return new AppService();
    }
}
