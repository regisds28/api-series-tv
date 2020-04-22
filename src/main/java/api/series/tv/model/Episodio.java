package api.series.tv.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Episodio")
@NoArgsConstructor
@EqualsAndHashCode
public class Episodio {

	@Id
	@SequenceGenerator(name = "episodios_seq")
	@GeneratedValue(generator = "episodios_seq", strategy = GenerationType.AUTO)
	private Long id;

	private int numeroEpisodio;

	private String tituloEpisodio;
	
	@JoinColumn(name = "temporada_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
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
	
	@JsonIgnore
	public Temporada getTemporada() {
		return temporada;
	}
	
	@JsonIgnore
	public void setTemporada(Temporada temporada) {
		this.temporada = temporada;
	}

}
