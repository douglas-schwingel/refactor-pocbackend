package com.maxmendes.pocbackend.lines.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Document(collection = "linhas")
public class Line implements Serializable {

    @Id
    @JsonProperty("id")
    private String id;

    @JsonProperty("codigo")
    private String code;

    @JsonProperty("nome")
    private String name;

    @JsonProperty("coordenadas")
    private List<Coordinate> cordinates;
}
