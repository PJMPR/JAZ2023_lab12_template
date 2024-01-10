package com.westeros.diagnostics.runners;

import com.westeros.diagnostics.service.contract.Diagnostics;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class DiskSpaceDiagnostics implements IDiagnose {

    @Override
    public String getName() {
        return "HDD Test";
    }

    @Override
    public String getDescription() {
        return "Check HDD for available space.";
    }

    @Override
    public Diagnostics run() {
        var diagnostics = new Diagnostics();
        diagnostics.setName(getName());
        diagnostics.setDescription(getDescription());
        var file = new File("c:/");
        var availibility = (double)file.getFreeSpace()/ file.getTotalSpace();
        if(availibility>0.05)diagnostics.setSuccess(true);
        else{
            diagnostics.setSuccess(false);
            diagnostics.setErrorMessage("HDD low space availability");
        }
        return diagnostics;
    }
}
