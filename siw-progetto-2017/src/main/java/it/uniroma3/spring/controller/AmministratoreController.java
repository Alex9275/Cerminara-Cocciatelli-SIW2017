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

import it.uniroma3.spring.modello.Amministratore;
import it.uniroma3.spring.modello.Autore;
import it.uniroma3.spring.modello.Opera;
import it.uniroma3.spring.service.AmministratoreService;
import it.uniroma3.spring.service.AutoreService;
import it.uniroma3.spring.service.OperaService;

@Controller
public class AmministratoreController {
	@Autowired
	AmministratoreService amministratoreService;
	@Autowired
	OperaService operaService;
	@Autowired
	AutoreService autoreService;

	@PostMapping("/amministratoreLogin")
	public String loginAmministratore(@Valid @ModelAttribute Amministratore amministratore, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "loginAmministratore"; //in caso di errore 
		} else {
			if(amministratoreService.findByUsername(amministratore.getUsername())==null) return "presenteAmministratore";
			Amministratore a = amministratoreService.findByUsername(amministratore.getUsername());
			if(!(a.getPassword().equals(amministratore.getPassword()))) return "passwordErrataAmministratore";
			model.addAttribute("nomeAmministratore",amministratore.getUsername());
		}
		return "privilegiAmministratore";
	}

	@PostMapping("/amministratoreRegistrato")
	public String registraAmministratore(@Valid @ModelAttribute Amministratore amministratore, BindingResult bindingResult, Model model) throws Exception {
		if (bindingResult.hasErrors()) {
			return "erroreRegistrazione";
		}
		else{
			if(amministratoreService.findByUsername(amministratore.getUsername())!=null) return "erroreRegistrazione";
			model.addAttribute(amministratore);
			amministratoreService.add(amministratore); 
		}
		return "privilegiAmministratore";
	}

	@PostMapping("/reload")
	public String reload(@Valid @ModelAttribute Amministratore amministratore, BindingResult bindingResult, Model model) {
		return "privilegiAmministratore";
	}

	@ModelAttribute("opere")
	public Iterable<Opera> opere(){
		Iterable <Opera> itopere=  operaService.findAll();
		List<Opera> opere = new LinkedList<>();
		for(Opera o : itopere){
			opere.add(o);
		}
		return opere;
	}

	@ModelAttribute("autori")
	public Iterable<Autore> autori(){
		Iterable <Autore> itautori=  autoreService.findAll();
		List<Autore> autori = new LinkedList<>();
		for(Autore a : itautori){
			autori.add(a);
		}
		return autori;
	}
}
