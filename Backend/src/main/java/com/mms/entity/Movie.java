package com.mms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Movie{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty
	@Pattern(regexp = "^[A-Za-z0-9 ]+$",message="The movie name should be combination of letters and numbers ")
	private String name;
	@NotNull
	private float imdb;
	@NotEmpty
	@Pattern(regexp = "^[A-Za-z ]+$",message="The movie name should be combination of letters")
	private String director;
	@NotEmpty
	@Pattern(regexp = "^[A-Za-z ]+$",message="The genre should be combination of letters")
	private String genre;
	
	public Movie() {
		super();
	}

	public Movie(int id,
			@NotEmpty @Pattern(regexp = "^[A-Za-z0-9 ]+$", message = "The movie name should be combination of letters and numbers ") String name,
			@NotNull float imdb,
			@NotEmpty @Pattern(regexp = "^[A-Za-z+-]+$", message = "The movie name should be combination of letters") String director,
			@NotEmpty @Pattern(regexp = "^[A-Za-z+-]+$", message = "The genre should be combination of letters") String genre) {
		super();
		this.id = id;
		this.name = name;
		this.imdb = imdb;
		this.director = director;
		this.genre = genre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getImdb() {
		return imdb;
	}

	public void setImdb(float imdb) {
		this.imdb = imdb;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", imdb=" + imdb + ", director=" + director + ", genre="
				+ genre + "]";
	}
	
	
	
	
}