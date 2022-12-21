package com.westeros.diagnostics.service;

import org.springframework.stereotype.Component;

@Component
public class DiagnosticsServiceClient implements IDiagnosticsServiceClient{
    @Override
    public void sendDiagnostics() {
        System.out.println("dzialam");//->wywalić
    }
}
