package br.com.belemburitiricardo.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.belemburitiricardo.dsmovie.dto.MovieDTO;
import br.com.belemburitiricardo.dsmovie.entities.Movie;
import br.com.belemburitiricardo.dsmovie.repositories.MovieRepository;

@Service
public class MovieService {
	
	/*composição de componentes*/
	/*Framework já tem um gerenciamento de dependencias*/
	@Autowired
	private MovieRepository repository;
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable) {
		Page<Movie> result = repository.findAll(pageable);
		
		Page<MovieDTO> page = result.map(x -> new MovieDTO(x));
		
		return page;
		
	}
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		Movie result = repository.findById(id).get();
		MovieDTO dto = new MovieDTO(result);
		
		return dto;
		
	}
}
