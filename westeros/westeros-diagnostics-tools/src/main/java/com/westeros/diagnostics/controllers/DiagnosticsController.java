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

    private final IRunDiagnoses diagnosticsRunner;

    @GetMapping("check")
    public ResponseEntity<DiagnosticsResultsDto> runDiagnostics(){
        var diagnosticsResults = diagnosticsRunner.runAll();
        var diagnostics  = new DiagnosticsResultsDto();
        diagnostics.setDiagnostics(diagnosticsResults);
        return ResponseEntity.ok(diagnostics);
    }

    @GetMapping
    public ResponseEntity<String> checkStatus(){
        return ResponseEntity.ok("ALIVE");
    }
}
