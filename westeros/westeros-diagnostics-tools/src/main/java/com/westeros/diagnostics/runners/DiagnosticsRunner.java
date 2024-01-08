package com.westeros.diagnostics.runners;

import com.westeros.diagnostics.service.contract.Diagnostics;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public class DiagnosticsRunner implements IRunDiagnoses {


    @Override
    public List<Diagnostics> runAll() {
        return null;
    }
}
