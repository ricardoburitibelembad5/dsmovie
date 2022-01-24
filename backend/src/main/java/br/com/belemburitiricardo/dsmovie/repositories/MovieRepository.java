package br.com.belemburitiricardo.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.belemburitiricardo.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

	/*OBJETO RESPONSAVEL POR BUSCA AS INFORMAÇÕES*/
}
