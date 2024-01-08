package com.westeros.diagnostics.controllers;

import com.westeros.diagnostics.runners.IRunDiagnoses;
import com.westeros.diagnostics.service.contract.DiagnosticsResultsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("diagnostics")
@RequiredArgsConstructor
public class DiagnosticsController {

    private final IRunDiagnoses runner;

    @GetMapping("check")
    public  ResponseEntity<DiagnosticsResultsDto> runDiagnostics(){
        var diagnosticResults = runner.runAll();
        var result = new DiagnosticsResultsDto();
        result.setDiagnostics(diagnosticResults);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<String> checkStatus(){
        return ResponseEntity.ok("ALIVE");
    }
}
