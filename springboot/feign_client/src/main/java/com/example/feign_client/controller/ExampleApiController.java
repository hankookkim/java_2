package com.example.feign_client.controller;

import com.example.feign_client.client.ExampleClient;
import com.example.feign_client.service.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/feign/data")
public class ExampleApiController {

    private final ExampleService exampleService;

    @GetMapping("/{id}")
    public String getData(@PathVariable Long id){
        System.out.println("[CLIENT] GET IN");
        return exampleService.getDataById(id);
    }

    @PostMapping
    public String createData(@RequestParam String name, @RequestParam int value){
        return exampleService.createData(name, value);
    }

    @PutMapping("/{id}")
    public String updateData(
            @PathVariable Long id,
            @RequestParam String name, @RequestParam int value){
        return exampleService.updateData(id, name, value);
    }

    @DeleteMapping("{id}")
public String deleteData(@PathVariable Long id){
        return exampleService.deleteData(id);

    }
}
