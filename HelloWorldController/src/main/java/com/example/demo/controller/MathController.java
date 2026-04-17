package com.example.demo.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.interfaces.MathService;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@RestController
@RequiredArgsConstructor
public class MathController {
	
	//creating no args constructor
	
	@Autowired
	private Random random;
	

    private final MathService mathService;
        
    private final ApplicationContext context;
    
    //read value from application.properties
    
   @Value("${server.port}")
   private String portNumber;
   
   
    @GetMapping("/math/add")
    public int add(@RequestParam int val1,@RequestParam int val2) {
    	
        log.info("Adding two number add: value1={}, value2={}", val1, val2);
  
        int result = mathService.add(val1, val2);
        log.info("Adding two number: result={}", result); 
        return result;
    }

 
    @GetMapping("/math/sub")
    public int sub(@RequestParam int a,@RequestParam int b) {
        // Trace entry
        log.info("subtracting two number: a={}, b={}", a, b);

        int result = mathService.sub(a, b);

        // Trace result before returning
        log.info("subtracting two number: result={}", result);
        return result;
    }
    
    @GetMapping("/math/multiply")
    public int mul(@RequestParam int m1,@RequestParam int m2) {
        log.info("Adding two number add: value1={}, value2={}", m1, m2);
        int result = mathService.mul(m1, m2);
        log.info("Adding two number: result={}", result);
        return result;
    }
    
    @PostConstruct
    public void init() {
    	
    	//Dependency lookup
    	MathService mathServiceFromContext = context.getBean(MathService.class);
    	log.info("Dependency lookup: {}", mathServiceFromContext);
    	
    	//Dependency injection via required args constructor
    	log.info("Dependency injected: {}", mathService);
    	
    	//printing port number
    	log.info("MathController is running on port: {}", portNumber);
    	
    	log.info("MathController called with ApplicationContext dependency: {}", context);
    	
    	Random refer=context.getBean(Random.class);
        log.info("Random number from context: {}", refer);
       
        log.info("MathController initialized with Random dependency injected: {}", random);
    }
}
