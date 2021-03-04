package com.maxmendes.pocbackend.contract.facade;

import com.maxmendes.pocbackend.contract.mapper.LinesMapper;
import com.maxmendes.pocbackend.contract.model.LineResponse;
import com.maxmendes.pocbackend.lines.facade.LinesFacade;
import com.maxmendes.pocbackend.lines.model.Line;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LinesContractFacade {
    
    private final LinesFacade linesFacade;
    private final LinesMapper linesMapper;
    
    public List<LineResponse> getAllLines(){
        return linesFacade.getLines().stream()
                .map(linesMapper::mapToResponse)
                .collect(Collectors.toList());
    }
}
