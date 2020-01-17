package jwd.EvidencijaTakmicenja.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tblTakmicenje")
public class Takmicenje {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	@Column(name = "naziv")
	private String naziv;
	@ManyToOne(fetch = FetchType.EAGER)
	private FormatTakmicenja format;
	@OneToMany(mappedBy = "takmicenje", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Ucesnik> ucesnici = new ArrayList<>();

	public Takmicenje() {
		super();
	}

	public List<Ucesnik> getUcesnici() {
		return ucesnici;
	}

	public void setUcesnici(List<Ucesnik> ucesnici) {
		this.ucesnici = ucesnici;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public FormatTakmicenja getFormat() {
		return format;
	}

	public void setFormat(FormatTakmicenja format) {
		this.format = format;
		if (!format.getTakmicenja().contains(this)) {
			format.getTakmicenja().add(this);
		}
	}

}
