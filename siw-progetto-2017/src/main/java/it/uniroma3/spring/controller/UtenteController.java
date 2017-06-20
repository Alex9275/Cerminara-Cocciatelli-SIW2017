package it.uniroma3.spring.controller;

import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.spring.modello.Opera;
import it.uniroma3.spring.modello.Utente;
import it.uniroma3.spring.service.OperaService;
import it.uniroma3.spring.service.UtenteService;

@Controller
public class UtenteController {
	@Autowired
	UtenteService utenteService;
	@Autowired
	OperaService operaService;

	@PostMapping("/loginUtente")
	public String loginUtente(@Valid @ModelAttribute Utente utente, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "errore"; 
		}else{
			if(utenteService.findByUserName(utente.getUsername())==null) return "presente";
			Utente u = utenteService.findByUserName(utente.getUsername());
			if(!(u.getPassword().equals(utente.getPassword()))) return "passwordErrataUtente";		
		}
		model.addAttribute("username",utente.getUsername());
		return "loginUtenteOk";
	}

	@PostMapping("/registraUtente")
	public String inserisciNuovoUtente(@Valid @ModelAttribute Utente utente, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "errore";
		} else {
			if(utenteService.findByUserName(utente.getUsername())!=null) return "erroreRegistrazione";
			model.addAttribute(utente);
			utenteService.add(utente); 
		}
		return "loginUtenteOk";
	}

	@PostMapping("/aggiornaUtente")
	public String cambiaUsername(@Valid @ModelAttribute Utente utente, BindingResult bindingResult, Model model,
			@RequestParam(value="id") String userOld) {
		if (bindingResult.hasErrors()) {
			return "errore";
		}
		else {
			Utente u = utenteService.findByUserName(userOld);
			if(utenteService.findByUserName(utente.getUsername())==null){
			u.setUsername(utente.getUsername());
			model.addAttribute(utente);
			utenteService.add(u); 
			}
			else return "cambiaUsername";
		}
		return "loginUtenteOk";
	}

	@ModelAttribute("opere")
	public Iterable<Opera> opere(){
		Iterable <Opera> iterator = operaService.findAll();
		List<Opera> opere = new LinkedList<>();
		for(Opera o : iterator){
			opere.add(o);
		}
		return opere;
	}
}
