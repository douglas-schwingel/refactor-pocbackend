package com.maxmendes.pocbackend.lines.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Coordinate {

    @JsonProperty("lat")
    private String lat;

    @JsonProperty("lng")
    private String lng;
}
