package no.hvl.dat108.oblig4_del1;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class DeltagerForm {
	
	@NotBlank
	@Pattern(regexp = "^[A-ZÆØÅ][a-zA-ZæøåÆØÅ\\- ]{1,19}$",
			message = "Fornavn må starte med stor bokstav og ha 2-20 bokstaver")
	private String fornavn;
	
	@NotBlank
	@Pattern(regexp = "^[A-ZÆØÅ][a-zA-ZæøåÆØÅ\\-]{1,19}$",
			message = "Etternavn må starte med stor bokstav og ha 2-20 bokstaver")
	private String etternavn;

	@Pattern(regexp = "^[0-9]{8}$",
			message = "Mobilnummer må ha 8 siffer")
	private String mobil;

	@Size(min = 4, message = "Passord må ha minst 4 tegn")
	private String passord;

	private String repeterPassord;

	@Pattern(regexp = "^(mann|kvinne)$")
	private String kjonn;

	// getters og setters
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

	public String getRepeterPassord() {
		return repeterPassord;
	}

	public void setRepeterPassord(String repeterPassord) {
		this.repeterPassord = repeterPassord;
	}

	public String getKjonn() {
		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}
}
