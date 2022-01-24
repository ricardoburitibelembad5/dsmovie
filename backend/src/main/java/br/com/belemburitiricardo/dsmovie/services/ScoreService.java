package br.com.belemburitiricardo.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.belemburitiricardo.dsmovie.dto.MovieDTO;
import br.com.belemburitiricardo.dsmovie.dto.ScoreDTO;
import br.com.belemburitiricardo.dsmovie.entities.Movie;
import br.com.belemburitiricardo.dsmovie.entities.Score;
import br.com.belemburitiricardo.dsmovie.entities.User;
import br.com.belemburitiricardo.dsmovie.repositories.MovieRepository;
import br.com.belemburitiricardo.dsmovie.repositories.ScoreRepository;
import br.com.belemburitiricardo.dsmovie.repositories.UserRepository;

@Service
public class ScoreService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		
		User user = userRepository.findByEmail(dto.getEmail());
		if(user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user); // saveAndFlush - garantia de objeto atualizado
		}
		
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		score = scoreRepository.saveAndFlush(score);
		
		
		double sum = 0.0;
		//percorrendo todos os scores do movie
		for( Score s : movie.getScores()) {
			sum = sum + s.getValue();
		}
		
		double avg = sum / movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);
		
	}
	
	
	
}
