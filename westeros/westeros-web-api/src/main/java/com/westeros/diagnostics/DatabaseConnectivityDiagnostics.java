package com.westeros.diagnostics;

import com.westeros.data.repositories.ICatalogData;
import com.westeros.diagnostics.runners.IDiagnose;
import com.westeros.diagnostics.service.contract.Diagnostics;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DatabaseConnectivityDiagnostics implements IDiagnose
{
    private final ICatalogData db;

    @Override
    public String getName() {
        return "DB Test";
    }

    @Override
    public String getDescription() {
        return "Check Database connectivity";
    }

    @Override
    public Diagnostics run() {
        var diagnosticResult = new Diagnostics();
        diagnosticResult.setName(getName());
        diagnosticResult.setDescription(getDescription());
        try{
            db.getMovies().count();
            diagnosticResult.setSuccess(true);
        }catch(Exception ex){
            diagnosticResult.setSuccess(false);
            diagnosticResult.setErrorMessage(ex.getMessage());
        }
        return diagnosticResult;
    }
}
