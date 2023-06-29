package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableFeignClients
public class Demo1Application {
    @Autowired
    GitHubProxy gitHubProxy;

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }
    @EventListener(ApplicationStartedEvent.class)
    public void makeRequestToGitHub(){
        String response = gitHubProxy.downloadUsersRepos("kalqa");
    }

}
