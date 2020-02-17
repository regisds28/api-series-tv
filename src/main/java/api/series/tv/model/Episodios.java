package api.series.tv.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Episodios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	
	private int numeroEpisodio;	
	
	private String tituloEpisodio;
	
	@JsonIgnore
	@ForeignKey(name = "temporada_id")
	@ManyToOne
	private Temporada temporada;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNumeroEpisodio() {
		return numeroEpisodio;
	}
	public void setNumeroEpisodio(int numeroEpisodio) {
		this.numeroEpisodio = numeroEpisodio;
	}
	public String getTituloEpisodio() {
		return tituloEpisodio;
	}
	public void setTituloEpisodio(String tituloEpisodio) {
		this.tituloEpisodio = tituloEpisodio;
	}
	
	public void setTemporada(Temporada temporada) {
		this.temporada = temporada;
	}
	
	public Temporada getTemporada() {
		return temporada;
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
		Episodios other = (Episodios) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
