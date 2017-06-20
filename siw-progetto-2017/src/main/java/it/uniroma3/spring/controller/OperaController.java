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

import it.uniroma3.spring.modello.Opera;
import it.uniroma3.spring.service.OperaService;

@Controller
public class OperaController {
	
	@Autowired
	OperaService operaService;
	
    @GetMapping("/opera")
    public String showForm(Opera opera) {
        return "form";
    }

    @PostMapping("/aggiungiOpera")
    public String inserisciNuovaOpera(@Valid @ModelAttribute Opera opera, BindingResult bindingResult, Model model) {
    	
        if (bindingResult.hasErrors()) {
            return "privilegiAmministratore";
        } else {
        	operaService.add(opera); 
        	Iterable <Opera> itopere = operaService.findAll();
    		List<Opera> opere = new LinkedList<>();
    		for(Opera o : itopere){
    			opere.add(o);
    		}
    		model.addAttribute("opere", opere);
        }
        return "privilegiAmministratore";
    }
    
    @PostMapping("/rimuoviOpera")
    public String rimuoviOpera(@Valid @ModelAttribute Opera opera, BindingResult bindingResult, Model model) {
    	
        if (bindingResult.hasErrors()) {
            return "privilegiAmministratore";
        } else {
        	operaService.remove(opera);
        	Iterable <Opera> itopere = operaService.findAll();
    		List<Opera> opere = new LinkedList<>();
    		for(Opera o : itopere){
    			opere.add(o);
    		}
    		model.addAttribute("opere", opere);
        }
        return "privilegiAmministratore";
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
