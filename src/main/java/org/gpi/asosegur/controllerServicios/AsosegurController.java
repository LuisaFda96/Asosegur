package org.gpi.asosegur.controllerServicios;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/asosegur")
@SessionAttributes("servicios")
public class AsosegurController {

	@GetMapping("/servicios")
	public String getServicios(Model model) {
		model.addAttribute("titulo", "Servicios");
		return "servicios/servicios";
	}
}
