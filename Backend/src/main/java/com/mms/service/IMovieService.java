package com.mms.service;

import java.util.List;
import java.util.Optional;

import com.mms.entity.*;

public interface IMovieService{
	
	List<Movie> getAllMovies();
	
	Optional<Movie> getMovieById(int id);
	
	void addMovie(Movie movie);
	
	void updateMovie(Movie movie, int id);
	
	void deleteMovie(int id);
	
	List<Movie> getMovieByDirector(String director);
	
	List<Movie> getMovieByImdb(float imdb);

	List<Movie> getMovieByGenre(String genre);
	

	
}
