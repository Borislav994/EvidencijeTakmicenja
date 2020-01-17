package jwd.EvidencijaTakmicenja.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tblFormat")
public class FormatTakmicenja {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	@Column(name = "naziv", nullable = false)
	private String naziv;
	@Column(name = "brojUcesnika", nullable = false)
	private Integer brojUcesnika;
	@Column(name = "pobede")
	private Integer pobede;
	@Column(name = "nereseno" )
	private Integer nereseno;
	@Column(name = "gubitak")
	private Integer gubitak;
	@OneToMany(mappedBy = "format", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Takmicenje> takmicenja = new ArrayList<>();

	public FormatTakmicenja() {
		super();
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

	public Integer getBrojUcesnika() {
		return brojUcesnika;
	}

	public void setBrojUcesnika(Integer brojUcesnika) {
		this.brojUcesnika = brojUcesnika;
	}

	public Integer getPobede() {
		return pobede;
	}

	public void setPobede(Integer pobede) {
		this.pobede = pobede;
	}

	public Integer getNereseno() {
		return nereseno;
	}

	public void setNereseno(Integer nereseno) {
		this.nereseno = nereseno;
	}

	public Integer getGubitak() {
		return gubitak;
	}

	public void setGubitak(Integer gubitak) {
		this.gubitak = gubitak;
	}

	public List<Takmicenje> getTakmicenja() {
		return takmicenja;
	}

	public void setTakmicenja(List<Takmicenje> takmicenja) {
		this.takmicenja = takmicenja;
	}

}
