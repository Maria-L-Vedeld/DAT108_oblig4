package no.hvl.dat108.oblig4_del1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class DeltagerController {

	@Autowired
	private DeltagerService service;

	@GetMapping("/") //localhost:8080/ skal vise påmeldingsskjema
	public String visSkjema(Model model) {
		model.addAttribute("deltagerForm", new DeltagerForm());
		return "paamelding";
	}

	@PostMapping("/paamelding") // localhost:8080/paameldt skal vise påmeldings medlding
	public String registrer(@Valid @ModelAttribute("deltagerForm") DeltagerForm form, BindingResult binding,
			Model model) {

		if (binding.hasErrors()) {
		    model.addAttribute("valideringsfeil", binding.getAllErrors());
		    return "paamelding";
		}


		Deltager ny = new Deltager(
				form.getMobil(), 
				form.getPassord(), 
				form.getFornavn(), 
				form.getEtternavn(),
				form.getKjonn()
				);
		service.leggTil(ny);

		model.addAttribute("deltager", ny);
		return "bekreftelse";
	}

	@GetMapping("/deltagerliste") // skal vise de som er meldt på i en tabell sotert etter for- så etternavn.
	public String liste(Model model) {
		model.addAttribute("deltagere", service.hentAlle());
		return "deltagerliste";
	}
}
