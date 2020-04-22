package api.series.tv.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import api.series.tv.model.Serie;

@Repository
public interface SerieRepository extends CrudRepository<Serie, Long> {

}
