package api.series.tv.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import api.series.tv.model.Serie;

@RepositoryRestResource
public interface SerieRepository extends CrudRepository<Serie, Long> {

}
