package ua.ithillel.firstspring.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import ua.ithillel.firstspring.entity.Car;

@Configuration
@ComponentScan("ua.ithillel.firstspring.configuration")
@PropertySource("classpath:application.properties")
public class BeanConfiguration {
    @Value("${queue.name}")
    private String queueName;
    @Value("${port.name}")
    private int port;

    @Bean
    @Scope("prototype")
    public Car getCustomCar() {
        return new Car("Audi", "A8", 2023);
    }

    @Bean
    public String getQueueName() {
        return queueName;
    }

    @Bean
    public int getPort() {
        return port;
    }
}
