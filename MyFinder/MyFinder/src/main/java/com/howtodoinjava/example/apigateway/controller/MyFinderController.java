package com.howtodoinjava.example.apigateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class MyFinderController {
	
	@Autowired
    RestTemplate restTemplate;
 
    @RequestMapping(value = "/getActeurByName/{firstName}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String getName(@PathVariable String firstName)
    {
        System.out.println("le nom est " + firstName);
 
        String response = restTemplate.exchange("http://my-movie/getActeurByName/{firstName}",
                                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, firstName).getBody();
 
        System.out.println("Response Body " + response);
 
        return "firstName -  " + firstName + " [ name  : " + response+" ]";
    }
    
    public String  fallbackMethod(String firstName){
    	
    	return "Fallback response:: No employee details available temporarily";
    }
 
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
