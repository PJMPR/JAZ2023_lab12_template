package com.westeros.diagnostics;


import com.westeros.data.repositories.ICatalogData;
import com.westeros.diagnostics.runners.IDiagnose;
import com.westeros.diagnostics.service.contract.Diagnostics;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DatabaseConnectivityDiagnostics implements IDiagnose
{
    private final ICatalogData db;
    @Override
    public String getName() {
        return "Db Tests";
    }
    @Override
    public String getDescription() {
        return "Check Westeros Database Connectivity";
    }
    @Override
    public Diagnostics run() {
        var diagnostics = new Diagnostics();
        diagnostics.setName(getName());
        diagnostics.setDescription(getDescription());
        try {
            db.getMovies().count();
            diagnostics.setSuccess(true);
        }catch(Exception ex){
            diagnostics.setSuccess(false);
            diagnostics.setErrorMessage(ex.getMessage());
        }

        return diagnostics;
    }
}
