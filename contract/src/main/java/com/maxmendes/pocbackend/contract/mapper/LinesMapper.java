package com.maxmendes.pocbackend.contract.mapper;

import com.maxmendes.pocbackend.contract.model.LineResponse;
import com.maxmendes.pocbackend.lines.model.Line;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LinesMapper {

    public LineResponse mapToResponse(Line busLine){
        return LineResponse.builder()
                .id(busLine.getId())
                .name(busLine.getName())
                .code(busLine.getCode())
                .build();
    }
}
