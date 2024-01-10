package com.westeros.diagnostics;

import com.westeros.diagnostics.runners.IDiagnose;
import com.westeros.diagnostics.service.contract.Diagnostics;
import com.westeros.moviesclient.IMoviesClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@RequiredArgsConstructor
@Component
public class TheMovieDbApiConnectivityDiagnostics implements IDiagnose
{
    private final IMoviesClient client;

    @Override
    public String getName() {
        return "The Movie DB Test";
    }

    @Override
    public String getDescription() {
        return "Check Connectivity to TheMovieDb.org services";
    }

    @Override
    public Diagnostics run() {
        var diagnostics = new Diagnostics();
        diagnostics.setName(getName());
        diagnostics.setDescription(getDescription());
        try{
            client.getByDateRange(LocalDate.now().minusDays(1), LocalDate.now());
            diagnostics.setSuccess(true);
        }catch(Exception ex){
            diagnostics.setSuccess(false);
            diagnostics.setErrorMessage(ex.getMessage());
        }

        return diagnostics;
    }
}
