package it.uniroma3.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// controller to access the login page
@Controller
public class MainController {

	// Login form
	@RequestMapping("/loginUtente.html")
	public String loginUtente() {
		return "loginUtente";
	}

	// Login form with error
	@RequestMapping("/errore.html")
	public String loginError(Model model) {
		model.addAttribute("errore", true);
		return "loginUtente";
	}

	//Register form
	@RequestMapping("/registrazioneUtente.html")
	public String registraUtente() {
		return "registrazioneUtente";
	}
	
	@RequestMapping("/loginAmministratore.html")
	public String loginAmministratore() {
		return "loginAmministratore";
	}
	
	@RequestMapping("/erroreRegistrazione.html")
	public String erroreRegistrazione() {
		return "erroreRegistrazione";
	}
	
	@RequestMapping("/registrazioneAmministratore.html")
	public String registraAmministratore() {
		return "registrazioneAmministratore";
	}
	
	@RequestMapping("/cambiaUsername.html")
	public String aggiornaUtente() {
		return "cambiaUsername";
	}
	
	@RequestMapping("/presente.html")
	public String presente() {
		return "presente";
	}
	
	@RequestMapping("/passwordErrataUtente.html")
	public String passwordErrata() {
		return "passwordErrataUtente";
	}
	
	@RequestMapping("/presenteAmministratore.html")
	public String presenteAmm() {
		return "presenteAmministratore";
	}
}