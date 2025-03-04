package com.example.feign_client.client;


import com.example.feign_client.dto.DataRequestDto;
import com.example.feign_client.dto.DataResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/api/data/all")
    List<DataResponseDto> getAllData();
}


//String 반환 타입은 단순한 텍스트 응답을 전달할 때 사용됩니다.
// 만약 데이터가 복잡한 구조를 가진 객체라면, 그 객체를 JSON 형태로 반환하는 것이 더 일반적입니다.
// String을 사용하는 것은 간단한 텍스트 응답이 필요한 경우에 적합합니다.