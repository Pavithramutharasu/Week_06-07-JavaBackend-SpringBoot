package com.example.greeting.service;

import com.example.greeting.model.Greeting;
import com.example.greeting.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    public String getSimpleGreeting() {
        return "Hello World from Service!";
    }

    public Greeting saveGreeting(String message) {
        return greetingRepository.save(new Greeting(message));
    }

    public Optional<Greeting> findGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

    public List<Greeting> findAllGreetings() {
        return greetingRepository.findAll();
    }

    public Greeting updateGreeting(Long id, String newMessage) {
        Greeting greeting = greetingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found"));
        greeting.setMessage(newMessage);
        return greetingRepository.save(greeting);
    }

    public void deleteGreeting(Long id) {
        greetingRepository.deleteById(id);
    }
}
