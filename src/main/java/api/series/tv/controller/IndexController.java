package api.series.tv.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.series.tv.model.Autor;
import api.series.tv.model.Serie;
import api.series.tv.service.AutorService;
import api.series.tv.service.SerieService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping
public class IndexController {

	@Autowired
	private SerieService serieService;
	
	@Autowired
	private AutorService autorService;

	@GetMapping(value = "/", produces = "application/json")
	public List<Serie> getSeries() {
		return serieService.getAllSeries();
	}

	@GetMapping(value = "/serie-{id}", produces = "application/json")
	public Optional<Serie> serie(@PathVariable(value = "id") Long serieId) {
		return serieService.getSerieById(serieId);
	}	

	@PostMapping(value = "/", produces = "application/json") 
	public Serie insertSerie(@RequestBody Serie serie) {
		return serieService.insertSerie(serie);	
	}
	
	@PostMapping(value = "/serie-{id}/autor", produces = "application/json") 
	public Autor insertAutor(@PathVariable(value = "id") Long id, @RequestBody Autor autor) {
		return autorService.createBook(id, autor);	
	}
	
	@PutMapping(value = "/", produces = "application/json") 
	public Serie updateSerie(@RequestBody Serie serie) {
		return serieService.updateSerie(serie);	
	}
	
	@DeleteMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Serie> deleteSerie(@PathVariable(value = "id") long id){
		return serieService.deleteAuthorById(id);
	}
	/*
	 * @PostMapping(value = "/", produces = "application/json") public
	 * ResponseEntity<Serie> cadastrar(@RequestBody Serie serie) {
	 * 
	 * for (int pos = 0; pos < serie.getElenco().size(); pos++) {
	 * serie.getElenco().get(pos).setSerie(serie); }
	 * 
	 * for (int pos = 0; pos < serie.getTemporada().size(); pos++) {
	 * serie.getTemporada().get(pos).setSerie(serie); }
	 * 
	 * Serie serieSalvo = serieRepository.save(serie);
	 * 
	 * return new ResponseEntity<Serie>(serieSalvo, HttpStatus.OK);
	 * 
	 * }
	 * 
	 * 
	 * @PutMapping(value = "/", produces = "application/json") public
	 * ResponseEntity<Serie> atualizar(@RequestBody Serie serie) {
	 * 
	 * for (int pos = 0; pos < serie.getElenco().size(); pos++) {
	 * serie.getElenco().get(pos).setSerie(serie); }
	 * 
	 * for (int pos = 0; pos < serie.getTemporada().size(); pos++) {
	 * serie.getTemporada().get(pos).setSerie(serie); }
	 * 
	 * Serie serieSalvo = serieRepository.save(serie);
	 * 
	 * return new ResponseEntity<Serie>(serieSalvo, HttpStatus.OK);
	 * 
	 * }
	 */

}
