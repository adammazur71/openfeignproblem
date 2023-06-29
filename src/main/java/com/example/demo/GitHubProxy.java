package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "github-client", url = "https://api.github.com")
public interface GitHubProxy {
    //https://api.github.com/users/{username}/repos
//    @RequestMapping(method = RequestMethod.GET, value = "/users/{username}/repos")
    @GetMapping("/users/{username}/repos")
    public String downloadUsersRepos(@PathVariable String username);
}
