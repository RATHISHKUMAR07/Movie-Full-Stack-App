package com.mms.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mms.entity.Movie;
import com.mms.service.IMovieService;


@RestController
@CrossOrigin("http://localhost:3000")
public class MovieController {


	@Autowired
	private IMovieService iMovieService;
	
	
	
	@GetMapping("/movies")
	public List<Movie> getAllMovies(){
		return iMovieService.getAllMovies();
	}
	
	@GetMapping("/movies/{id}")
	public Optional<Movie> getMovieById(@PathVariable int id) {
		return iMovieService.getMovieById(id);
	}
	
	@PostMapping("/movies")
	public void addMovie(@RequestBody Movie movie) {
		iMovieService.addMovie(movie);
	}
	
	@PutMapping("/movies/{id}")
	public void updateMovie(@RequestBody Movie movie, @PathVariable int id) {
		iMovieService.updateMovie(movie, id);
	}
	
	
	@DeleteMapping("/movies/{id}")
	public void deleteMovie(@PathVariable int id) {
		iMovieService.deleteMovie(id);
	}
	
	@GetMapping("/movies/director/{director}")
	public List<Movie> getMovieByDirector(@PathVariable String director){
		return iMovieService.getMovieByDirector(director);
	}
	
	@GetMapping("/movies/imdb/{imdb}")
	public List<Movie> getMovieByImdb(@PathVariable float imdb){
		return iMovieService.getMovieByImdb(imdb);
	}
	
	@GetMapping("/movies/genre/{genre}")
	public List<Movie> getMovieByGenre(@PathVariable String genre){
		return iMovieService.getMovieByGenre(genre);
	}

}
