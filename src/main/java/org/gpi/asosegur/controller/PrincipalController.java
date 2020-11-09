package org.gpi.asosegur.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/asosegur")
@SessionAttributes("principal")
public class PrincipalController {

	
	@GetMapping("")
	public String formPrincipal(Model model) {
		model.addAttribute("titulo", "Asosegur");
		return "principal/vista_principal";
	}
	
	@GetMapping("/nosotros")
	public String vNosotros(Model model) {
		model.addAttribute("titulo", "Nosotros");
		return "principal/nosotros";
	}
	
	@GetMapping("/contacto")
	public String vContacto(Model model) {
		model.addAttribute("titulo", "Contacto");
		return "principal/contacto";
	}
}
