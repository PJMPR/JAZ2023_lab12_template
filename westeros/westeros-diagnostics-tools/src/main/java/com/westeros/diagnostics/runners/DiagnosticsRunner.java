package com.westeros.diagnostics.runners;

import com.westeros.diagnostics.service.contract.Diagnostics;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiagnosticsRunner implements IRunDiagnoses {

    private final List<IDiagnose> diagnosticsTests;

    @Override
    public List<Diagnostics> runAll() {

        return diagnosticsTests.stream().map(x->x.run()).toList();
    }
}
