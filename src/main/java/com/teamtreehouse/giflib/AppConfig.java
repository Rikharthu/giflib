package com.teamtreehouse.giflib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/** Main..
 * In the main method we are going to call a method from spring boot library
 * that will run our application, creating a new application context
 *
 * context -
 */

// in order for spring to be auto-configure

@EnableAutoConfiguration
// used on a configuration class for telling the Spring Framework to scan for components
@ComponentScan
public class AppConfig {

    public static void main(String[] args) {
        // run a swing application
        SpringApplication.run(AppConfig.class, args);
        System.out.println("http://localhost:8080/gif?name=book-dominos");
        System.out.println("http://localhost:8080/gif?name=cowboy-coder");
    }

}
