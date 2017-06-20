package it.uniroma3.spring.controller;

import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.spring.modello.Autore;
import it.uniroma3.spring.modello.Opera;
import it.uniroma3.spring.service.AutoreService;
import it.uniroma3.spring.service.OperaService;

@Controller
public class AutoreController {
	@Autowired
	AutoreService autoreService;
	@Autowired
	OperaService operaService;
	
    @GetMapping("/autore")
    public String showForm(Opera opera) {
        return "form";
    }

    @PostMapping("/aggiungiAutore")
    public String inserisciNuovoAutore(@Valid @ModelAttribute Autore autore, BindingResult bindingResult, Model model) {
    	
        if (bindingResult.hasErrors()) {
            return "privilegiAmministratore";
        } else {	
        	autoreService.add(autore); 
        	model.addAttribute("autori", autori());
        }
        return "privilegiAmministratore";
    }
    
	@ModelAttribute("autori")
	public Iterable<Autore> autori(){
		Iterable <Autore> iterator = autoreService.findAll();
		List<Autore> autori = new LinkedList<>();
		for(Autore a : iterator){
			autori.add(a);
		}
		return autori;
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
