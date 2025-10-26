package no.hvl.dat108.oblig4_del1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class DeltagerTest {
	private static Validator validator;

	@BeforeAll
	static void setupValidator() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	void gylidgDeltager_skalVæreGyldig() {

		DeltagerForm form = new DeltagerForm();

		form.setFornavn("Ola");
		form.setEtternavn("Normann");
		form.setMobil("11112222");
		form.setPassord("1234");
		form.setRepeterPassord("1234");
		form.setKjonn("mann");

		Set<ConstraintViolation<DeltagerForm>> feil = validator.validate(form);
		assertTrue(feil.isEmpty(), "Forventet at skjemaet er gyldig, men fikk feil: " + feil);
	}

	@Test
	void fornavnUtenStorBokstav_skalGiFeil() {

		DeltagerForm form = new DeltagerForm();

		form.setFornavn("ola");
		form.setEtternavn("Normann");
		form.setMobil("11112222");
		form.setPassord("1234");
		form.setRepeterPassord("1234");
		form.setKjonn("mann");

		Set<ConstraintViolation<DeltagerForm>> feil = validator.validate(form);
		assertFalse(feil.isEmpty(), "Fornavn uten stor bokstav burde gi valideringsfeil");
	}

	@Test
	void etternavnMedMellomrom_skalGiFeil() {
		DeltagerForm form = new DeltagerForm();
		form.setFornavn("Ola");
		form.setEtternavn("Van Hansen");
		form.setMobil("12345678");
		form.setPassord("abcd");
		form.setRepeterPassord("abcd");
		form.setKjonn("mann");

		Set<ConstraintViolation<DeltagerForm>> feil = validator.validate(form);
		assertFalse(feil.isEmpty(), "Etternavn med mellomrom skal ikke være gyldig");
	}

	@Test
	void mobilMedForMangeSiffer_skalGiFeil() {
		DeltagerForm form = new DeltagerForm();
		form.setFornavn("Ola");
		form.setEtternavn("Nordmann");
		form.setMobil("123456789");
		form.setPassord("pass");
		form.setRepeterPassord("pass");
		form.setKjonn("mann");

		Set<ConstraintViolation<DeltagerForm>> feil = validator.validate(form);
		assertFalse(feil.isEmpty(), "Mobilnummer som ikke har 8 siffer skla være ugyldig");
	}

	@Test
	void ugyldigKjonn_skalGiFeil() {
		DeltagerForm form = new DeltagerForm();
		form.setFornavn("Ola");
		form.setEtternavn("Nordmann");
		form.setMobil("12345678");
		form.setPassord("pass");
		form.setRepeterPassord("pass");
		form.setKjonn("annet");

		Set<ConstraintViolation<DeltagerForm>> feil = validator.validate(form);
		assertFalse(feil.isEmpty(), "Kjønn må være 'mann' eller 'kvinne'");
	}

}
