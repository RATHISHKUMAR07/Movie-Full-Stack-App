package com.mms.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mms.entity.Movie;
import com.mms.exception.MovieNotFoundException;
import com.mms.repository.MovieRepository;

@Service
public class MovieService implements IMovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public List<Movie> getAllMovies() {
		List<Movie> optionalMovie = movieRepository.findAll();
		if (optionalMovie.isEmpty()) {
			throw new MovieNotFoundException("Empty database add customers to display " + optionalMovie.size() + " Customers in database");
		} else {
			List<Movie> movie = new ArrayList<>();
			movieRepository.findAll().forEach(movie::add);

			return movie;
		}
	}

	@Override
	public Optional<Movie> getMovieById(int id) {
		Optional<Movie> optionalMovie = movieRepository.findById(id);
		if (!optionalMovie.isPresent()) {
			throw new MovieNotFoundException("Customer with the id is not found in the database " + id);
		} else {
			return movieRepository.findById(id);
		}
	}

	@Override
	public void addMovie(Movie movie) {
		Optional<Movie> optionalMovie = movieRepository.findById(movie.getId());
		if (optionalMovie.isPresent()) {
			throw new MovieNotFoundException(
					"Customer with the same id already added into database add with new id " + movie.getId());
		} else {
			movieRepository.save(movie);
		}
		
	}

	@Override
	public void updateMovie(Movie movie, int id) {
		Optional<Movie> optionalMovie = movieRepository.findById(id);

		if (!optionalMovie.isPresent()) {
			throw new MovieNotFoundException("No Customer is found with given Customer Id : " + id);
		} else {
			Movie existingMovie = optionalMovie.get();

			existingMovie.setId(movie.getId());
			existingMovie.setName(movie.getName());
			existingMovie.setImdb(movie.getImdb());
			existingMovie.setDirector(movie.getDirector());
			existingMovie.setGenre(movie.getGenre());

			movieRepository.save(existingMovie);
		}
		
	}

	@Override
	public void deleteMovie(int id) {
		Optional<Movie> optionalMovie = movieRepository.findById(id);

		if (!optionalMovie.isPresent()) {
			throw new MovieNotFoundException(
					"No Customer is found with given Customer Id to delete Customer : " + id);
		} else {
			movieRepository.deleteById(id);
		}
		
	}

	@Override
	public List<Movie> getMovieByDirector(String director) {
		List<Movie> optionalMovie = movieRepository.getMovieByDirector(director);
		if (optionalMovie.size() == 0) {
			throw new MovieNotFoundException("No Movie found with given director " + director);
		} else {
			return movieRepository.getMovieByDirector(director);
		}
	}

	@Override
	public List<Movie> getMovieByImdb(float imdb) {
		List<Movie> optionalMovie = movieRepository.getMovieByImdb(imdb);
		if (optionalMovie.size() == 0) {
			throw new MovieNotFoundException("No Movie found with given imdb greater than " + imdb);
		} else {
			return movieRepository.getMovieByImdb(imdb);
		}
	}

	@Override
	public List<Movie> getMovieByGenre(String genre) {
		List<Movie> optionalMovie = movieRepository.getMovieByGenre(genre);
		if (optionalMovie.size() == 0) {
			throw new MovieNotFoundException("No Movie found with given genre " + genre);
		} else {
		List<Movie> list = new ArrayList<>();
		movieRepository.getMovieByGenre(genre).forEach(list::add);
		return list;
		}
	}

}
