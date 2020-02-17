package api.series.tv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.series.tv.model.Elenco;
import api.series.tv.model.Series;
import api.series.tv.repository.SerieRepository;

@RestController
@RequestMapping(value = "/series")
public class IndexController {
	
	@Autowired
	private SerieRepository serieRepository;
	
	private Elenco elenco;
	
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<List<Series>> init(){
		
		List<Series> listSeries = (List<Series>) serieRepository.findAll();
		
		return new ResponseEntity<List<Series>>(listSeries, HttpStatus.OK);
		
	}

}
