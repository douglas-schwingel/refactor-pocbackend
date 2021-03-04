package com.maxmendes.pocbackend.lines.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maxmendes.pocbackend.lines.model.Coordinate;
import com.maxmendes.pocbackend.lines.model.Line;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class LinesOperations {

    @Value("${datapoa.URI}")
    private String datapoaURI;

    public List<Line> getAllLines(RestTemplate restTemplate, ObjectMapper objectMapper) {
        String linesString = restTemplate.getForObject(datapoaURI + "?a=nc&p=%&t=o", String.class);

        try {
            return Arrays.asList(objectMapper.readValue(linesString, Line[].class));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public String getAllLinesWithCordinates(RestTemplate restTemplate, String id) throws InterruptedException {
        try {
            Thread.sleep(50);
            return restTemplate.getForObject(datapoaURI + "?a=il&p=" + id, String.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String getCoordinatesString(String linesWithCoordinates) {

        String[] splitStringArray = linesWithCoordinates.split(",");
        StringBuilder builder = new StringBuilder();
        builder.append("{");

        for (int i = 3; i <= splitStringArray.length - 1; i++) {
            builder.append(splitStringArray[i]);
            builder.append(",");
        }

        builder.deleteCharAt(builder.lastIndexOf(","));

        return builder.toString();
    }

    public Map<String,Coordinate> getLineCoordinatesMap(String coordinateString) {

        try {
            return new ObjectMapper().readValue(coordinateString, new TypeReference<Map<String,Coordinate>>() {});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return Collections.emptyMap();
    }

    public List<Line> getAllItineray(RestTemplate restTemplate, ObjectMapper objectMapper){
        return getAllLines(restTemplate, objectMapper).stream()
                .peek(line -> populateLineCoordinates(restTemplate, line))
                .collect(Collectors.toList());
    }

    public void populateLineCoordinates(RestTemplate restTemplate, Line line){
        List<Coordinate> coordinates = new ArrayList<>();
        try {
            getLineCoordinatesMap(getCoordinatesString(getAllLinesWithCordinates(restTemplate, line.getId())))
            .forEach((k, v) -> coordinates.add(new Coordinate(v.getLat(), v.getLng())));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        line.setCordinates(coordinates);
    }
}
