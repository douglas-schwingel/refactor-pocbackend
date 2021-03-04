package com.maxmendes.pocbackend.lines.facade;

import com.maxmendes.pocbackend.lines.model.Line;
import com.maxmendes.pocbackend.lines.service.LinesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class LinesFacade {

    private final LinesService linesService;

    public List<Line> getLines(){
        return linesService.findLines();
    }
}
