package ua.ithillel.firstspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.ithillel.firstspring.configuration.BeanConfiguration;
import ua.ithillel.firstspring.controller.CarController;
import ua.ithillel.firstspring.entity.Car;
import ua.ithillel.firstspring.entity.House;
import ua.ithillel.firstspring.service.CarBuilder;
import ua.ithillel.firstspring.service.HouseService;

import java.util.List;

@SpringBootApplication
public class FirstSpringApplication {

    public static void main(String[] args) {

        //task1 - create Spring Boot application
        ConfigurableApplicationContext run = SpringApplication.run(FirstSpringApplication.class, args);

        //task2(part1) - create Bean @Configuration(scope - prototype)
//        var context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
//        Car customCar = context.getBean("getCustomCar", Car.class);
//        customCar.setBrand("VW");
//        customCar.setModel("Golf");
//        customCar.setYearOfProduction(2019);
//        Car customCar2 = context.getBean("getCustomCar", Car.class);
//        System.out.println(customCar);
//        System.out.println(customCar2);

        //task2(part2) - create @Bean annotation(scope - singleton(default))
//        House house = run.getBean(House.class);
//        house.setAddress("Kiyv,str.Shevchenko,10");
//        house.setNumberOfFloors(4);
//        System.out.println(house);
//        House newHouse = run.getBean(House.class);
//        System.out.println(newHouse);

        //task3 - get configuration from application.properties through @value
//        var context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
//        String queueName = context.getBean("getQueueName", String.class);
//        System.out.println(queueName);
//        Integer port = context.getBean("getPort", Integer.class);
//        System.out.println(port);

        //task4 - create Beans(Component -> Controller -> Service -> Repository)
//        CarBuilder carBuilder = run.getBean(CarBuilder.class);
//        List<Car> allCars = carBuilder.getAll();
//        allCars.forEach(System.out::println);
    }
}
