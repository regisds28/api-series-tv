package api.series.tv.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Temporada")
@NoArgsConstructor
@EqualsAndHashCode
public class Temporada {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private int numeroTemporada;

	@OneToMany(mappedBy = "temporada", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Episodio> episodio = new ArrayList<Episodio>();

	@JoinColumn(name = "serie_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne(fetch = FetchType.LAZY)
	private Serie serie;

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

	public List<Episodio> getEpisodios() {
		return episodio;
	}

	public void setEpisodios(List<Episodio> episodio) {
		this.episodio = episodio;
	}

	@JsonIgnore
	public Serie getSerie() {
		return serie;
	}

	@JsonIgnore
	public void setSerie(Serie serie) {
		this.serie = serie;
	}
}
