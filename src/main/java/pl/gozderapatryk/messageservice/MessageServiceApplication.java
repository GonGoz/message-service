package pl.gozderapatryk.messageservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import pl.gozderapatryk.messageservice.utils.Misc;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class MessageServiceApplication {

    public static void main(String[] args) {
        var env = new SpringApplication(MessageServiceApplication.class).run(args).getEnvironment();
        log.info(Misc.getHelloMessage(env));
    }
}