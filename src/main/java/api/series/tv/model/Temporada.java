package api.series.tv.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Temporada {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id;
	
	private int numeroTemporada;
	
	@OneToMany(mappedBy = "temporada", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Episodios> episodios = new ArrayList<Episodios>();;
	
	@JsonIgnore
	@ForeignKey(name = "serie_id")
	@ManyToOne
	private Series serie;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumeroTemporada() {
		return numeroTemporada;
	}

	public void setNumeroTemporada(int numeroTemporada) {
		this.numeroTemporada = numeroTemporada;
	}

	public List<Episodios> getEpisodios() {
		return episodios;
	}

	public void setEpisodios(List<Episodios> episodios) {
		this.episodios = episodios;
	}

	public Series getSerie() {
		return serie;
	}

	public void setSerie(Series serie) {
		this.serie = serie;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Temporada other = (Temporada) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
