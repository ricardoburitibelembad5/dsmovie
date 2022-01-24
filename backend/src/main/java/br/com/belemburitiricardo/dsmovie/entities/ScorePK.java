package br.com.belemburitiricardo.dsmovie.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ScorePK implements Serializable{

	private static final long serialVersionUID = 1L;



	@ManyToOne
	@JoinColumn(name = "movie_id")
	private Movie Movie;
	
	

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User User;
	
	public ScorePK() {
	}
	
	public Movie getMovie() {
		return Movie;
	}
	
	public void setMovie(Movie movie) {
		Movie = movie;
	}
	
	public User getUser() {
		return User;
	}
	
	public void setUser(User user) {
		User = user;
	}
	
	
}
