package com.example.feign_client.service;


import com.example.feign_client.client.ExampleClient;
import com.example.feign_client.dto.DataRequestDto;
import com.example.feign_client.dto.DataResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExampleService {

    private final ExampleClient exampleClient;


    //    Get 요청 호출
    public String getDataById(Long id) {
        return exampleClient.getData(id);
    }


    public String createData(String name, int value) {
        return exampleClient.createData(
                DataRequestDto.builder()
                        .name(name)
                        .value(value)
                        .build()
        );
    }

    public String updateData(Long id, String name, int value) {
        return exampleClient.updateData(id,
                DataRequestDto.builder()
                        .name(name)
                        .value(value)
                        .build()
        );
    }
    public String deleteData(Long id) {

        return exampleClient.deleteData(id);
    }

   public List<DataResponseDto> getAllData() {
        return exampleClient.getAllData();

   }
}

