package com.maxmendes.pocbackend.lines.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maxmendes.pocbackend.lines.repository.LineRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@AllArgsConstructor
public class LinesUpdate {

    private final LinesOperations linesOperations;
    private final RestTemplateBuilder restTemplateBuilder;
    private final ObjectMapper objectMapper;
    private final LineRepository lineRepository;

    @Scheduled(cron = "0/30 * * * * *")
    public void updateDatabase() {
        lineRepository
                .saveAll(linesOperations.getAllItineray(restTemplateBuilder.build(), objectMapper));
    }
}
