package br.com.belemburitiricardo.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.belemburitiricardo.dsmovie.entities.Score;
import br.com.belemburitiricardo.dsmovie.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK>{

	/*OBJETO RESPONSAVEL POR BUSCA AS INFORMAÇÕES*/
}
