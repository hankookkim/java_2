package com.example.feign_client.client;


import com.example.feign_client.dto.DataRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="exampleClient", url = "${feign-data.url}")
public interface ExampleClient {

//    GET 요청(데이터 조회)
    @GetMapping("/api/data/{id}")
    String getData (@PathVariable("id") Long id);

    // POST 요청 (데이터 생성)
    @PostMapping("/api/data")
    String createData(@RequestBody DataRequestDto dataRequestDto);


    @PutMapping("/api/data/{id}")
    String updateData(@PathVariable("id") Long id, @RequestBody DataRequestDto dataRequestDto);

    @DeleteMapping("/api/data/{id}")
    String deleteData(@PathVariable("id") Long id);
}
