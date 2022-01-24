package br.com.belemburitiricardo.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.belemburitiricardo.dsmovie.dto.MovieDTO;
import br.com.belemburitiricardo.dsmovie.dto.ScoreDTO;
import br.com.belemburitiricardo.dsmovie.services.ScoreService;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {

	@Autowired
	private ScoreService service;
	
	@PutMapping //vai responder pelo get.
	public MovieDTO saveScore(@RequestBody ScoreDTO dto){ //anotattion que pega as informações do JSON @RequestBody
		
		MovieDTO movieDTO = service.saveScore(dto);
		
		
		return movieDTO;	
	}
}
