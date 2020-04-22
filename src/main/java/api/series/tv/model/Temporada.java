package api.series.tv.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Temporada")
@NoArgsConstructor
@EqualsAndHashCode
public class Temporada {

	@Id
	@SequenceGenerator(name = "temporada_seq")
	@GeneratedValue(generator = "temporada_seq", strategy = GenerationType.AUTO)
	private Long id;

	private int numeroTemporada;

	private String trailer;
	
	@JsonIgnoreProperties("temporada")
	@OneToMany(mappedBy = "temporada", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Episodio> episodios = new HashSet<>();

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

	public Set<Episodio> getEpisodios() {
		return episodios;
	}
	
	public void setEpisodios(Set<Episodio> episodios) {
		this.episodios = episodios;
	}
	
	public String getTrailer() {
		return trailer;
	}
	
	public void setTrailer(String trailer) {
		this.trailer = trailer;
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
