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

import api.series.tv.model.Serie;
import api.series.tv.service.SerieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/series")
@Api(value = "API Rest Lista de Séries de TV")
public class SerieController {

	@Autowired
	private SerieService serieService;
	
	@GetMapping(value = "/", produces = "application/json")
	@ApiOperation(value = "Retorna uma lista completa de informações sobre séries", nickname = "")
	public List<Serie> getSeries() {
		return serieService.getAllSeries();
	}

	@GetMapping(value = "/serie-{id}", produces = "application/json")
	@ApiOperation(value = "Retorna um ID único de série")
	public Optional<Serie> getSerieById(@PathVariable(value = "id") Long serieId) {
		return serieService.getSerieById(serieId);
	}

	@PostMapping(value = "/", produces = "application/json")
	@ApiOperation(value = "Insere determinada série e cria-se o ID")
	public Serie insertSerie(@RequestBody Serie serie) {
		return serieService.insertSerie(serie);
	}

	@PutMapping(value = "/", produces = "application/json")
	@ApiOperation(value = "Atualiza determinada série pelo ID único")
	public ResponseEntity<Serie> updateSerie(@RequestBody Serie serie) {
		return serieService.updateSerie(serie);
	}

	@DeleteMapping(value = "/serie-{id}", produces = "application/json")
	@ApiOperation(value = "Deleta determinada série pelo ID único")
	public ResponseEntity<Serie> deleteSerie(@PathVariable(value = "id") long id) {
		return serieService.deleteSerieById(id);
	}

}
