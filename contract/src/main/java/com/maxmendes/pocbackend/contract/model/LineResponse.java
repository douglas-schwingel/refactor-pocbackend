package com.maxmendes.pocbackend.contract.model;

import com.maxmendes.pocbackend.lines.model.Coordinate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class LineResponse {
    private String id;
    private String name;
    private String code;
    private List<Coordinate> cordinates;
}
