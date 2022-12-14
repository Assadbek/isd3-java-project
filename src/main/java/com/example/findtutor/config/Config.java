package com.example.findtutor.config;

import com.example.findtutor.model.Tutor;
import com.example.findtutor.model.user.MyUser;
import com.example.findtutor.model.user.Role;
import com.example.findtutor.service.TutorService;
import com.example.findtutor.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class Config {

    @Bean
    CommandLineRunner commandLineRunner(UserService userService, TutorService tutorService) {
        return args -> {
            userService.saveRole(new Role( "USER"));
            userService.saveRole(new Role( "ADMIN"));
            userService.saveRole(new Role( "SUPERADMIN"));

            MyUser a=new MyUser( "kid","adam123",
                    "qwerty", new ArrayList<>());
            userService.saveUser(a);
            MyUser b=new MyUser("kudi","kudi123",
                    "qwerty", new ArrayList<>());
            userService.saveUser(b);

            userService.assignRole("adam123","USER");
            userService.assignRole("kudi123","USER");
            userService.assignRole("kudi123","ADMIN");

            tutorService.saveTutor(
                    Tutor.builder()
                            .user(b)
                            .experience("15 years")
                            .aboutMe("I like books").build()
            );

            tutorService.saveTutor(
                    Tutor.builder()
                            .user(a)
                            .experience("3 years")
                            .aboutMe("I like play basketball").build()
            );
        };
    }

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

}
