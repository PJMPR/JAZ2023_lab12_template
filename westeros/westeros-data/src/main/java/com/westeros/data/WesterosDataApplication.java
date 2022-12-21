package com.westeros.data;

import com.westeros.data.model.Company;
import com.westeros.data.repositories.ICatalogData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class WesterosDataApplication implements CommandLineRunner {

    private final ICatalogData db;

    public WesterosDataApplication(ICatalogData dataCatalog) {
        this.db = dataCatalog;
    }

    public static void main(String[] args) {
        SpringApplication.run(WesterosDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        var cmp = db.getCompanies();

        var company = new Company();
//        var movie = new Movie();
//        dataCatalog.getCompanies().save(company);
//        dataCatalog.getMovies().save(movie);
//        company.getMovies().add(movie);
//        movie.getProductionCompanies().add(company);
//        dataCatalog.getCompanies().save(company);


    }
}
