package com.mms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mms.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{
	
	@Query("SELECT c FROM Movie c WHERE c.director like %:director%")
	List<Movie> getMovieByDirector(@Param("director") String director);
	
	@Query("SELECT c FROM Movie c WHERE c.imdb >= :imdb")
	List<Movie> getMovieByImdb(@Param("imdb") float imdb);
	
	@Query("SELECT c FROM Movie c WHERE c.genre LIKE :genre")
	List<Movie> getMovieByGenre(@Param("genre") String genre);


}
