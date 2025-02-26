package com.example.feign_data_v2.controller;

import com.example.feign_data_v2.dto.DataRequestDto;
import com.example.feign_data_v2.dto.DataResponseDto;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("api/data")
public class DataContoller {

    private Map<Long, DataResponseDto> dataStore = new HashMap<>();

    private Long idCnt=1L;

    @PostConstruct
    public void initDataSource(){

        dataStore.put(idCnt++,new DataResponseDto(1L,"item1",100));
        dataStore.put(idCnt++,new DataResponseDto(1L,"item2",200));
        dataStore.put(idCnt++,new DataResponseDto(1L,"item3",300));
        dataStore.put(idCnt++,new DataResponseDto(1L,"item4",400));
        dataStore.put(idCnt++,new DataResponseDto(1L,"item5",500));

    }

    @GetMapping("/{id}")
    public DataResponseDto get(@PathVariable Long id){
        log.info("[Feign Data] select");
        return dataStore.get(id);
//        dataStore(HashMap)에 저장된 데이터 중 id에 해당하는 데이터를 가져온다.
    }

    @PostMapping
    public DataResponseDto createDate(@RequestBody DataRequestDto dataRequestDto){
        log.info("[Feign Data] create");
        DataResponseDto newData= DataResponseDto.builder()
                .id(idCnt)
                .name(dataRequestDto.getName())
                .value(dataRequestDto.getValue())
                .build();

        dataStore.put(idCnt++,newData);

        return newData;
    }

    @PutMapping("/{id}")
    public DataResponseDto updateData(
            @PathVariable Long id,
            @RequestBody DataRequestDto dataRequestDto
    ){
        log.info("[Feign Data] update");
        DataResponseDto  dataResponseDto = dataStore.get(id);
        dataResponseDto.setName(dataRequestDto.getName());
        dataResponseDto.setValue(dataRequestDto.getValue());
        dataStore.put(id,dataResponseDto);
        return dataResponseDto;


    }

    @DeleteMapping("/{id}")
    public DataResponseDto delete(@PathVariable Long id){
        log.info("[Feign Data] delete");
        DataResponseDto dataResponseDto = dataStore.get(id);
        dataStore.remove(id);
        return dataResponseDto;
    }

}
