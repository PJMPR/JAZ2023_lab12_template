package com.westeros.webapi.services;

import com.westeros.webapi.contract.MovieDto;
import com.westeros.webapi.contract.MovieSummaryDto;

import java.util.List;

public interface IMovieService {

    long saveMovie(MovieDto dto);

    List<MovieSummaryDto> getAll();
}
