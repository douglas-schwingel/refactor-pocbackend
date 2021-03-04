package com.maxmendes.pocbackend.lines.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maxmendes.pocbackend.lines.integration.LinesOperations;
import com.maxmendes.pocbackend.lines.model.Line;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LinesService {

    private final LinesOperations linesOperations;
    private final RestTemplateBuilder restTemplateBuilder;
    private final ObjectMapper objectMapper;

    public List<Line> findLines(){
        return linesOperations.getAllLines(restTemplateBuilder.build(), objectMapper);
    }

    public List<Line> findAllItinerary(){
        return linesOperations.getAllItineray(restTemplateBuilder.build(), objectMapper);
    }
}
