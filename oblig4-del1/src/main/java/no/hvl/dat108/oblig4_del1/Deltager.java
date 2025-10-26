package no.hvl.dat108.oblig4_del1;

public class Deltager {

	private String fornavn;
	private String etternavn;
	private String mobil;
	private String passord; // del 2
	private String kjonn; // gjøres til knapp??

	public Deltager(String mobil, String passord, String fornavn, String etternavn, String kjonn) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.mobil = mobil;
		this.passord = passord;
		this.kjonn = kjonn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

	public String getKjonn() {
		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}

//	public String getHeleNavnet() {
//		return fornavn + " " + etternavn;
//	}
}
