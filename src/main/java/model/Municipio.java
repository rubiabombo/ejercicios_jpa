package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the municipio database table.
 * 
 */
@Entity
@NamedQuery(name="Municipio.findAll", query="SELECT m FROM Municipio m")
public class Municipio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MUNICIPIO_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MUNICIPIO_ID_GENERATOR")
	private int id;

	private int codMunicipio;

	private String nombre;

	//bi-directional many-to-one association to Provincia
	@ManyToOne
	@JoinColumn(name="idProvincia")
	private Provincia provincia;

	public Municipio() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodMunicipio() {
		return this.codMunicipio;
	}

	public void setCodMunicipio(int codMunicipio) {
		this.codMunicipio = codMunicipio;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Provincia getProvincia() {
		return this.provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	@Override
	public String toString() {
		return nombre;
	}
	
	

}