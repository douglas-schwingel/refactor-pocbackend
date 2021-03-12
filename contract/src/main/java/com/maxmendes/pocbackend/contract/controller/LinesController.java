package com.maxmendes.pocbackend.contract.controller;

import com.maxmendes.pocbackend.contract.facade.LinesContractFacade;
import com.maxmendes.pocbackend.contract.model.LineResponse;
// TODO cuidar os imports não utilizados
import com.maxmendes.pocbackend.lines.model.Line;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/v1/linhas")
@RestController
@AllArgsConstructor
public class LinesController {

    private final LinesContractFacade linesContractFacade;

//    TODO o default já é o OK. Não precisa explicitar
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<LineResponse> getAllBusLines(){
        return linesContractFacade.getAllLines();
    }
}
