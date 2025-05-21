package com.example.greeting.controller;

import com.example.greeting.model.Greeting;
import com.example.greeting.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    // UC1 & UC2: Simple Greeting
    @GetMapping
    public String getSimpleGreeting() {
        return greetingService.getSimpleGreeting();
    }

    // UC3: Greeting with names
    @GetMapping("/custom")
    public String getCustomGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {

        if (firstName != null && lastName != null)
            return "Hello " + firstName + " " + lastName;
        else if (firstName != null)
            return "Hello " + firstName;
        else if (lastName != null)
            return "Hello " + lastName;
        else
            return greetingService.getSimpleGreeting();
    }

    // UC4: Save greeting
    @PostMapping
    public Greeting createGreeting(@RequestBody Greeting greeting) {
        return greetingService.saveGreeting(greeting.getMessage());
    }

    // UC5: Find by ID
    @GetMapping("/{id}")
    public ResponseEntity<Greeting> getGreetingById(@PathVariable Long id) {
        return greetingService.findGreetingById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UC6: List all
    @GetMapping("/all")
    public List<Greeting> getAllGreetings() {
        return greetingService.findAllGreetings();
    }

    // UC7: Edit greeting
    @PutMapping("/{id}")
    public Greeting updateGreeting(@PathVariable Long id, @RequestBody Greeting greeting) {
        return greetingService.updateGreeting(id, greeting.getMessage());
    }

    // UC8: Delete greeting
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGreeting(@PathVariable Long id) {
        greetingService.deleteGreeting(id);
        return ResponseEntity.noContent().build();
    }
}
