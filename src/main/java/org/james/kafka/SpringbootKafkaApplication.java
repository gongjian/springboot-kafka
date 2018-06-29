package org.james.kafka;

import org.james.kafka.entity.KafkaProperties;
import org.james.kafka.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(KafkaProperties.class)
public class SpringbootKafkaApplication implements CommandLineRunner, ApplicationRunner {

    @Autowired
    private KafkaProperties kafkaProperties;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootKafkaApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println(kafkaProperties.getT1());

        List<String> classes = SpringFactoriesLoader.loadFactoryNames(MyService.class, this.getClass().getClassLoader());
        classes.forEach(clazz -> System.out.println(clazz));

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(args.getOptionValues("home"));
    }
}
