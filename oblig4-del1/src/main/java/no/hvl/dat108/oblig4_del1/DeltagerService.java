package no.hvl.dat108.oblig4_del1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DeltagerService {
	private final List<Deltager> deltagere = new ArrayList<>();

	public DeltagerService() {
			deltagere.add(new Deltager("90123456", "1234", "Arne", "Arnesen", "mann"));
			deltagere.add(new Deltager("23456789", "abcd", "Anne", "Panne", "kvinne"));
			deltagere.add(new Deltager("34567890", "pass", "Per", "Viskelær", "mann"));
			deltagere.add(new Deltager("45678901", "test", "Per", "Persen", "mann"));
			deltagere.add(new Deltager("56789012", "1234", "Oline", "Olsen", "kvinne"));
		}

	public boolean finnesMobil(String mobil) {
		return deltagere.stream().anyMatch(d -> d.getMobil().equals(mobil));
	}

	public void leggTil(Deltager d) {
		deltagere.add(d);
	}

	public List<Deltager> hentAlle() {
	    return deltagere.stream()
	            .sorted(Comparator
	                .comparing(Deltager::getFornavn, String.CASE_INSENSITIVE_ORDER)
	                .thenComparing(Deltager::getEtternavn, String.CASE_INSENSITIVE_ORDER))
	            .toList();
	}

}