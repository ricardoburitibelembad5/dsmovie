package br.com.belemburitiricardo.dsmovie.entities;

import java.io.Serializable;

import javax.persistence.Embeddable; //especificação e não implementação - hibernate
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/*classe auxiliar*/
@Embeddable
public class ScorePK implements Serializable{

	private static final long serialVersionUID = 1L;

/*chaves estrangeiras - chave primaria composta*/
	
	/*Mapeamento objeto-relacional*/

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
